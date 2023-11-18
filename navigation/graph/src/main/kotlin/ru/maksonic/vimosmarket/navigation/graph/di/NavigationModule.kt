package ru.maksonic.vimosmarket.navigation.graph.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.maksonic.vimosmarket.navigation.router.NavigationKeyStore
import ru.maksonic.vimosmarket.navigation.router.Router

/**
 * @Author maksonic on 16.11.2023
 */
@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    fun provideNavigationKeyStore(): NavigationKeyStore = NavigationKeyStoreCore()

    @Provides
    fun provideNavigation(keyStore: NavigationKeyStore): Router = AppNavigator(keyStore)
}