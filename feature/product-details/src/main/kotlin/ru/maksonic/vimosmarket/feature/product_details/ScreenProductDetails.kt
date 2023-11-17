package ru.maksonic.vimosmarket.feature.product_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import ru.maksonic.vimosmarket.common.ui.BaseScreen
import ru.maksonic.vimosmarket.feature.product_details.databinding.ScreenProductDetailsBinding

/**
 * @Author maksonic on 16.11.2023
 */
@AndroidEntryPoint
class ScreenProductDetails : BaseScreen<ScreenProductDetailsBinding>() {
    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> ScreenProductDetailsBinding
        get() = ScreenProductDetailsBinding::inflate

    override fun render(savedInstanceState: Bundle?) {

    }
}