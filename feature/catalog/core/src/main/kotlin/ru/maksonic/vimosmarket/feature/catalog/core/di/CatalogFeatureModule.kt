package ru.maksonic.vimosmarket.feature.catalog.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.maksonic.vimosmarket.feature.catalog.api.ProductDomainToUiMapper
import ru.maksonic.vimosmarket.feature.catalog.core.core.ProductDomainToUiMapperCore

/**
 * @Author maksonic on 17.11.2023
 */
@Module
@InstallIn(ViewModelComponent::class)
object CatalogFeatureModule {
    @Provides
    fun provideMapper(): ProductDomainToUiMapper = ProductDomainToUiMapperCore()
}