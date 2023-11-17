package ru.maksonic.vimosmarket.feature.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
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
    private var _adapter: CatalogAdapter? = null
    private val adapter: CatalogAdapter
        get() = requireNotNull(_adapter)

    override fun render(savedInstanceState: Bundle?) {
        setStatusBarColor()
        initListAdapter()
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

    private fun initListAdapter() {
        _adapter = CatalogAdapter(
            onProductClicked = { router.navigateFromCatalogToDetails(this) },
            imageLoader = imageLoader
        )
        binding.catalogRecyclerView.adapter = adapter
    }

    private fun loadingState() {
        binding.loadingState.visibility = View.VISIBLE
    }

    private fun successState(list: List<ProductUiModel>) {
        adapter.submitList(list)

        with(binding) {
            loadingState.visibility = View.GONE
            failureState.visibility = View.GONE
        }
    }

    private fun failureState(message: String) {
        with(binding) {
            loadingState.visibility = View.GONE
            failureState.visibility = View.VISIBLE
            failMessage.text = message
        }
    }
}