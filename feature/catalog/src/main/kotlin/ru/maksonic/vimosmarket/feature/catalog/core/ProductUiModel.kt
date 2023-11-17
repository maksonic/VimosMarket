package ru.maksonic.vimosmarket.feature.catalog.core

/**
 * @Author maksonic on 16.11.2023
 */
data class ProductUiModel(
    val name: String,
    val price: String,
    val code: String,
    val imageLink: String?
)