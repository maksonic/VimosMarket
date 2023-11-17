package ru.maksonic.vimosmarket.domain

/**
 * @Author maksonic on 16.11.2023
 */
typealias ProductList = Result<List<ProductModel>>

data class ProductModel(
    val name: String,
    val price: Long = 0,
    val code: Long = 0,
    val imageLink: String?
)