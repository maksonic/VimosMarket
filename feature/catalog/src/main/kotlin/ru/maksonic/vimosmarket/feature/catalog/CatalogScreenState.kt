package ru.maksonic.vimosmarket.feature.catalog

import ru.maksonic.vimosmarket.feature.catalog.core.ProductUiModel

/**
 * @Author maksonic on 17.11.2023
 */
sealed class ProgressState {
    data object Loading : ProgressState()
    data object Success : ProgressState()
    data class Failure(val failInfo: String) : ProgressState()
}

data class ScreenState(
    val progress: ProgressState,
    val products: List<ProductUiModel>,
) {
    companion object {
        val Initial = ScreenState(ProgressState.Loading, emptyList())
    }
}