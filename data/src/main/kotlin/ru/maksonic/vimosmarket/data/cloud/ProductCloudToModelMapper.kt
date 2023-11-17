package ru.maksonic.vimosmarket.data.cloud

import ru.maksonic.vimosmarket.domain.ProductModel
import ru.maksonic.vimosmarket.common.core.Mapper
import javax.inject.Inject

/**
 * @Author maksonic on 17.11.2023
 */
interface ProductCloudToModelMapper : Mapper<ProductCloudModel, ProductModel> {
    class Mapper @Inject constructor() : ProductCloudToModelMapper {
        override fun mapTo(i: ProductCloudModel) =
            ProductModel(name = i.name, price = i.price, code = i.code, imageLink = i.imageLink)

        override fun mapFrom(o: ProductModel) = ProductCloudModel(
            name = o.name, price = o.price, code = o.code, imageLink = o.imageLink
        )
    }
}