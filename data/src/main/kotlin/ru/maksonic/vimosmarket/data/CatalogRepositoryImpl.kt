package ru.maksonic.vimosmarket.data

import ru.maksonic.vimosmarket.data.cloud.CloudStore
import ru.maksonic.vimosmarket.data.cloud.ProductCloudToModelMapper
import ru.maksonic.vimosmarket.domain.CatalogRepository
import ru.maksonic.vimosmarket.domain.ProductList
import javax.inject.Inject

/**
 * @Author maksonic on 17.11.2023
 */
class CatalogRepositoryImpl @Inject constructor(
    private val cloudStore: CloudStore,
    private val cloudMapper: ProductCloudToModelMapper
) : CatalogRepository {
    override suspend fun fetchProductList(): ProductList = cloudStore.getProducts().fold(
        onSuccess = { Result.success(cloudMapper.mapListTo(it)) },
        onFailure = { Result.failure(it) }
    )
}