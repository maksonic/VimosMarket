package ru.maksonic.vimosmarket.domain

/**
 * @Author maksonic on 17.11.2023
 */
interface CatalogRepository {
    suspend fun fetchProductList(): ProductList
}