package ru.maksonic.vimosmarket.feature.catalog.core.core

import ru.maksonic.vimosmarket.domain.ProductModel
import ru.maksonic.vimosmarket.feature.catalog.api.ProductDomainToUiMapper
import ru.maksonic.vimosmarket.feature.catalog.api.ProductUiModel

/**
 * @Author maksonic on 16.11.2023
 */
class ProductDomainToUiMapperCore : ProductDomainToUiMapper {
    override fun mapTo(i: ProductModel) =
        ProductUiModel(name = i.name, price = i.price, code = i.code, imageLink = i.imageLink)

    override fun mapFrom(o: ProductUiModel) = ProductModel(name = o.name, imageLink = o.imageLink)
}