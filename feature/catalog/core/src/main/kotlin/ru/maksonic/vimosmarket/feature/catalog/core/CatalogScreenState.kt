package ru.maksonic.vimosmarket.feature.catalog.core

import ru.maksonic.vimosmarket.common.ui.ProgressState
import ru.maksonic.vimosmarket.feature.catalog.api.ProductUiModel

/**
 * @Author maksonic on 17.11.2023
 */
data class CatalogScreenState(
    val progress: ProgressState,
    val products: List<ProductUiModel>,
) {
    companion object {
        val Initial = CatalogScreenState(ProgressState.Loading, emptyList())
    }
}