package ru.maksonic.vimosmarket.feature.product_details

import ru.maksonic.vimosmarket.feature.catalog.api.ProductUiModel

/**
 * @Author maksonic on 18.11.2023
 */
data class ProductDetailsScreenState(
    val isEmptyProduct: Boolean,
    val product: ProductUiModel
) {
    companion object {
        val Initial = ProductDetailsScreenState(true, product = ProductUiModel.Default)
    }
}