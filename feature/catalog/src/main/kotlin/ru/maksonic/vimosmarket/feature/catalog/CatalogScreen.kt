package ru.maksonic.vimosmarket.feature.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint
import ru.maksonic.vimosmarket.common.ui.BaseScreen
import ru.maksonic.vimosmarket.feature.catalog.core.ProductUiModel
import ru.maksonic.vimosmarket.feature.catalog.core.adapter.CatalogAdapter
import ru.maksonic.vimosmarket.feature.catalog.databinding.ScreenCatalogBinding
import ru.maksonic.vimosmarket.navigation.router.Router
import java.math.BigDecimal
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

    private var _adapter: CatalogAdapter? = null
    private val adapter: CatalogAdapter
        get() = requireNotNull(_adapter)

    override fun render(savedInstanceState: Bundle?) {
        setStatusBarColor()
        initListAdapter()
        /*binding.button.setOnClickListener {
            router.navigateFromCatalogToDetails(this)
        }*/
    }

    private fun setStatusBarColor() {
        requireActivity().window.statusBarColor = requireContext().getColor(ru.maksonic.vimosmarket.common.ui.R.color.primary)
    }

    private fun initListAdapter() {
        _adapter = CatalogAdapter(
            onProductClicked = { router.navigateFromCatalogToDetails(this) },
            imageLoader = imageLoader
        )
        val list = listOf(ProductUiModel(1, "AAA", BigDecimal(100), "ZZZZZ"))
        adapter.submitList(list)
        binding.catalogRecyclerView.adapter = adapter
    }
}