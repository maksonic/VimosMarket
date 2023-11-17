package ru.maksonic.vimosmarket.data.cloud

import retrofit2.http.GET

/**
 * @Author maksonic on 17.11.2023
 */
interface ApiService {
    @GET("products?cat_id=1000457&limit=10&offset=0&base_id=1&sort_type=0")
    suspend fun getProducts(): CloudProducts
}