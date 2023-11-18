package ru.maksonic.vimosmarket.feature.product_details

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.maksonic.vimosmarket.feature.catalog.api.ProductUiModel

/**
 * @Author maksonic on 18.11.2023
 */
class ProductDetailsViewModel : ViewModel() {
    private val _state = MutableStateFlow(ProductDetailsScreenState.Initial)
    val state = _state.asStateFlow()

    fun fetchPassedProduct(product: ProductUiModel?) {
        if (product == null) {
            _state.update { it.copy(isEmptyProduct = true) }
        } else {
            _state.update { it.copy(isEmptyProduct = false, product = product) }
        }
    }
}