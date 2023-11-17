package ru.maksonic.vimosmarket.feature.catalog.core

import ru.maksonic.vimosmarket.common.core.Mapper
import ru.maksonic.vimosmarket.domain.ProductModel

/**
 * @Author maksonic on 16.11.2023
 */
interface ProductDomainToUiMapper : Mapper<ProductModel, ProductUiModel> {
    class Mapper : ProductDomainToUiMapper {
        override fun mapTo(i: ProductModel) = ProductUiModel(
            name = i.name,
            price = i.price,
            code = i.code,
            imageLink = i.imageLink
        )

        override fun mapFrom(o: ProductUiModel) = ProductModel(
            name = o.name,
            price = o.price,
            code = o.code,
            imageLink = o.imageLink
        )
    }
}