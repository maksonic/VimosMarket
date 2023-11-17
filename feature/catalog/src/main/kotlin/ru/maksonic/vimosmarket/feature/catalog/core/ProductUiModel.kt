package ru.maksonic.vimosmarket.feature.catalog.core

import java.math.BigDecimal

/**
 * @Author maksonic on 16.11.2023
 */
data class ProductUiModel(
    val id: Long,
    val name: String,
    val price: BigDecimal,
    val code: String,
)