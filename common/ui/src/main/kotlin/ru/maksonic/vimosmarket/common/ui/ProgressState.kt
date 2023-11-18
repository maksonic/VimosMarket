package ru.maksonic.vimosmarket.common.ui

/**
 * @Author maksonic on 18.11.2023
 */
sealed class ProgressState {
    data object Loading : ProgressState()
    data object Success : ProgressState()
    data class Failure(val failInfo: String) : ProgressState()
}