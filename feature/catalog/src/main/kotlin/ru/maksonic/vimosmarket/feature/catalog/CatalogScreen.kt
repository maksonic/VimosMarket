package ru.maksonic.vimosmarket.feature.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.maksonic.vimosmarket.common.ui.BaseScreen
import ru.maksonic.vimosmarket.feature.catalog.databinding.ScreenCatalogBinding

/**
 * @Author maksonic on 16.11.2023
 */
class CatalogScreen : BaseScreen<ScreenCatalogBinding>() {
    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> ScreenCatalogBinding
        get() = ScreenCatalogBinding::inflate

    override fun render(savedInstanceState: Bundle?) {

    }
}