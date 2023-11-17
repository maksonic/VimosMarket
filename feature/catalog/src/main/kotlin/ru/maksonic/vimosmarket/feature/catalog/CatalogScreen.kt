package ru.maksonic.vimosmarket.feature.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.RequestManager
import androidx.lifecycle.flowWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.maksonic.vimosmarket.common.ui.BaseScreen
import ru.maksonic.vimosmarket.common.ui.R
import ru.maksonic.vimosmarket.common.ui.hidden
import ru.maksonic.vimosmarket.common.ui.showed
import ru.maksonic.vimosmarket.feature.catalog.adapter.CatalogAdapter
import ru.maksonic.vimosmarket.feature.catalog.core.CatalogViewModel
import ru.maksonic.vimosmarket.feature.catalog.core.ProductUiModel
import ru.maksonic.vimosmarket.feature.catalog.databinding.ScreenCatalogBinding
import ru.maksonic.vimosmarket.navigation.router.Router
import javax.inject.Inject

/**
 * @Author maksonic on 16.11.2023
 */
@AndroidEntryPoint
class CatalogScreen : BaseScreen<ScreenCatalogBinding>() {
    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> ScreenCatalogBinding
        get() = ScreenCatalogBinding::inflate

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var imageLoader: RequestManager

    private val viewModel: CatalogViewModel by viewModels()
    private val adapter: CatalogAdapter by lazy(::initCatalogAdapter)

    override fun render(savedInstanceState: Bundle?) {
        setStatusBarColor()
        applyAdapterToRecycler()
        handleState()
    }

    private fun handleState() = lifecycleScope.launch {
        viewModel.state.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).collect { state ->
            when (state.progress) {
                is ProgressState.Loading -> loadingState()
                is ProgressState.Success -> successState(state.products)
                is ProgressState.Failure -> failureState(state.progress.failInfo)
            }
        }
    }

    private fun setStatusBarColor() {
        requireActivity().window.statusBarColor = requireContext().getColor(R.color.primary)
    }

    private fun initCatalogAdapter() = CatalogAdapter(
        onProductClicked = { router.navigateFromCatalogToDetails(this) },
        imageLoader = imageLoader
    )

    private fun applyAdapterToRecycler() {
        binding.catalogRecyclerView.adapter = adapter
    }

    private fun loadingState() = with(binding) {
        loadingState.root.showed()
        failureState.root.hidden()
    }

    private fun successState(list: List<ProductUiModel>) {
        adapter.submitList(list)

        with(binding) {
            loadingState.root.hidden()
            failureState.root.hidden()
        }
    }

    private fun failureState(message: String) = with(binding) {
        loadingState.root.hidden()
        failureState.root.showed()
        failureState.failMessage.text = message

        failureState.btnRetryFetchData.setOnClickListener {
            viewModel.retryFetchData()
        }
    }
}