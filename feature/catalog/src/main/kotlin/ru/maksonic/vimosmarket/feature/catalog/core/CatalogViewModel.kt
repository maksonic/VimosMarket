package ru.maksonic.vimosmarket.feature.catalog.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.maksonic.vimosmarket.common.ui.ResourceProvider
import ru.maksonic.vimosmarket.domain.CatalogRepository
import ru.maksonic.vimosmarket.feature.catalog.ProgressState
import ru.maksonic.vimosmarket.feature.catalog.R
import ru.maksonic.vimosmarket.feature.catalog.ScreenState
import javax.inject.Inject

/**
 * @Author maksonic on 17.11.2023
 */
@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val repository: CatalogRepository,
    private val mapper: ProductDomainToUiMapper,
    private val resourceProvider: ResourceProvider
) : ViewModel() {
    private val _state = MutableStateFlow(ScreenState.Initial)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            fetchProducts()
        }
    }

    private suspend fun fetchProducts() = repository.fetchProductList()
        .onSuccess { success(mapper.mapListTo(it)) }
        .onFailure { failure() }

    private fun success(products: List<ProductUiModel>) =
        _state.update { it.copy(progress = ProgressState.Success, products = products) }

    private fun failure() = _state.update {
        val failInfo = resourceProvider.getString(R.string.error_msg_fetch_products)
        it.copy(progress = ProgressState.Failure(failInfo))
    }
}