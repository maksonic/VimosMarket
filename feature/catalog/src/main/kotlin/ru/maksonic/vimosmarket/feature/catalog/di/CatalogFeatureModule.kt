package ru.maksonic.vimosmarket.feature.catalog.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.maksonic.vimosmarket.feature.catalog.core.ProductDomainToUiMapper

/**
 * @Author maksonic on 17.11.2023
 */
@Module
@InstallIn(ViewModelComponent::class)
object CatalogFeatureModule {
    @Provides
    fun provideMapper(): ProductDomainToUiMapper = ProductDomainToUiMapper.Mapper()
}