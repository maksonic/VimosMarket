package ru.maksonic.vimosmarket.navigation.router

import androidx.fragment.app.Fragment

/**
 * @Author maksonic on 16.11.2023
 */
interface Router {
    fun navigateFromCatalogToDetails(fragment: Fragment)
}