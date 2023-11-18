package ru.maksonic.vimosmarket.feature.catalog.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint
import ru.maksonic.vimosmarket.common.ui.BaseScreen
import ru.maksonic.vimosmarket.common.ui.ProgressState
import ru.maksonic.vimosmarket.common.ui.R
import ru.maksonic.vimosmarket.common.ui.hidden
import ru.maksonic.vimosmarket.common.ui.showed
import ru.maksonic.vimosmarket.feature.catalog.api.ProductUiModel
import ru.maksonic.vimosmarket.feature.catalog.core.adapter.CatalogAdapter
import ru.maksonic.vimosmarket.feature.catalog.core.core.CatalogViewModel
import ru.maksonic.vimosmarket.feature.catalog.core.databinding.ScreenCatalogBinding
import ru.maksonic.vimosmarket.navigation.router.Router
import javax.inject.Inject

/**
 * @Author maksonic on 16.11.2023
 */
@AndroidEntryPoint
class CatalogScreen : BaseScreen<ScreenCatalogBinding>() {
    override val initBinding: (LayoutInflater, ViewGroup?, Boolean) -> ScreenCatalogBinding
        get() = ScreenCatalogBinding::inflate

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var imageLoader: RequestManager

    private val viewModel: CatalogViewModel by viewModels()
    private val adapter: CatalogAdapter by lazy(::initCatalogAdapter)

    override fun render(savedInstanceState: Bundle?) {
        setStatusBarColor()
        hideNavigationBackIcon()
        setAdapterToRecycler()

        viewModel.state.handle { state ->
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
        onProductClicked = { product -> router.navigateFromCatalogToDetails(this, product) },
        imageLoader = imageLoader
    )

    private fun setAdapterToRecycler() {
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
        imageLoader.load(R.drawable.logo_state_error).into(binding.failureState.imagePlaceholder)

        failureState.btnRetryFetchData.setOnClickListener {
            viewModel.retryFetchData()
        }
    }
}