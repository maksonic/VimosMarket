package ru.maksonic.vimosmarket.feature.catalog.api

import ru.maksonic.vimosmarket.common.core.Mapper
import ru.maksonic.vimosmarket.domain.ProductModel

/**
 * @Author maksonic on 18.11.2023
 */
interface ProductDomainToUiMapper : Mapper<ProductModel, ProductUiModel>