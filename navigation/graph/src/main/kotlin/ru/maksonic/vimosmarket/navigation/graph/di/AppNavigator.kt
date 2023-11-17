package ru.maksonic.vimosmarket.navigation.graph.di

import androidx.fragment.app.Fragment
import ru.maksonic.vimosmarket.navigation.graph.R
import ru.maksonic.vimosmarket.navigation.router.Router
import javax.inject.Inject

/**
 * @Author maksonic on 16.11.2023
 */

class AppNavigator @Inject constructor() : AbstractNavigator(), Router {

    override fun navigateFromCatalogToDetails(fragment: Fragment) {
        fragment.navigate(R.id.action_catalogScreen_to_screenProductDetails, "passedProductKey")
    }
}

