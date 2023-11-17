package ru.maksonic.vimosmarket.feature.catalog.core

/**
 * @Author maksonic on 16.11.2023
 */
data class ProductUiModel(
    val name: String,
    val price: Long,
    val code: Long,
    val imageLink: String?
)