package ru.maksonic.vimosmarket.feature.product_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint
import ru.maksonic.vimosmarket.common.ui.BaseScreen
import ru.maksonic.vimosmarket.common.ui.R.drawable.logo_state_error
import ru.maksonic.vimosmarket.common.ui.R.string.title_product_price
import ru.maksonic.vimosmarket.common.ui.showed
import ru.maksonic.vimosmarket.feature.catalog.api.ProductUiModel
import ru.maksonic.vimosmarket.feature.product_details.R.string.title_product_details_code
import ru.maksonic.vimosmarket.common.ui.R.color.surface
import ru.maksonic.vimosmarket.common.ui.R.color.primary
import ru.maksonic.vimosmarket.feature.product_details.databinding.ScreenProductDetailsBinding
import ru.maksonic.vimosmarket.navigation.router.NavigationKeyStore
import ru.maksonic.vimosmarket.navigation.router.Router
import ru.maksonic.vimosmarket.navigation.router.getArgParcelable
import javax.inject.Inject

/**
 * @Author maksonic on 16.11.2023
 */
@AndroidEntryPoint
class ScreenProductDetails : BaseScreen<ScreenProductDetailsBinding>() {
    override val initBinding: (LayoutInflater, ViewGroup?, Boolean) -> ScreenProductDetailsBinding
        get() = ScreenProductDetailsBinding::inflate

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigationKeyStore: NavigationKeyStore

    @Inject
    lateinit var imageLoader: RequestManager

    private val viewModel: ProductDetailsViewModel by viewModels()

    override fun onLaunch(savedInstanceState: Bundle?) {
        viewModel.fetchPassedProduct(getArgParcelable(this, navigationKeyStore.productKey))
    }

    override fun render(savedInstanceState: Bundle?) {
        showNavigateBackIcon()
        setStatusBarColor(requireContext().getColor(primary))
        setNavigationBarColor(requireContext().getColor(surface))

        viewModel.state.handle { state ->
            if (state.isEmptyProduct) emptyState() else successState(state.product)
        }
    }

    private fun successState(product: ProductUiModel) = with(binding) {
        imageLoader.load(product.imageLink).into(image)
        code.text = getString(title_product_details_code, product.code)
        name.text = product.name
        price.text = getString(title_product_price, product.price)
    }

    private fun emptyState() = with(binding) {
        stateEmpty.root.showed()
        imageLoader.load(logo_state_error).into(stateEmpty.imagePlaceholder)

        stateEmpty.btnBack.setOnClickListener {
            router.onBack(this@ScreenProductDetails)
        }
    }
}