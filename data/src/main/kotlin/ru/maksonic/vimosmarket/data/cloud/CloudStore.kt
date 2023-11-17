package ru.maksonic.vimosmarket.data.cloud

import javax.inject.Inject

/**
 * @Author maksonic on 17.11.2023
 */
class CloudStore @Inject constructor(
    private val api: ApiService,
    private val baseImageUrl: String
) {
    suspend fun getProducts(): Result<List<ProductCloudModel>> = runCatching {
        api.getProducts().map { item -> item.copy(imageLink = baseImageUrl.plus(item.imageLink)) }
    }
}