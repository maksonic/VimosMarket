package ru.maksonic.vimosmarket.navigation.graph.di

import ru.maksonic.vimosmarket.navigation.router.NavigationKeyStore

/**
 * @Author maksonic on 18.11.2023
 */
class NavigationKeyStoreCore : NavigationKeyStore {
    override val productKey: String
        get() = "passedProductKey"
}