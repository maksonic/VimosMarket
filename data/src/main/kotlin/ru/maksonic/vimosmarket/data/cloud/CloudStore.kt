package ru.maksonic.vimosmarket.data.cloud

import javax.inject.Inject
import kotlin.random.Random

/**
 * @Author maksonic on 17.11.2023
 */
class CloudStore @Inject constructor(
    private val api: ApiService,
    private val baseImageUrl: String
) {
    suspend fun getProducts(): Result<List<ProductCloudModel>> = runCatching {
        if (Random.nextBoolean()) {
            throw Exception("Fake network error!")
        }
        api.getProducts().map { it.copy(imageLink = baseImageUrl.plus(it.imageLink)) }
    }
}