package ru.maksonic.vimosmarket.navigation.graph.di

import android.os.Parcelable
import androidx.fragment.app.Fragment
import ru.maksonic.vimosmarket.navigation.graph.R
import ru.maksonic.vimosmarket.navigation.router.NavigationKeyStore
import ru.maksonic.vimosmarket.navigation.router.Router
import javax.inject.Inject

/**
 * @Author maksonic on 16.11.2023
 */

class AppNavigator @Inject constructor(
    private val navigationKeyStore: NavigationKeyStore
) : AbstractNavigator(), Router {

    override fun <T : Parcelable> navigateFromCatalogToDetails(fragment: Fragment, data: T): Unit =
        fragment.navigate(
            actionId = R.id.action_catalogScreen_to_screenProductDetails,
            argKey = navigationKeyStore.productKey,
            data = data
        )

    override fun onBack(fragment: Fragment): Unit = fragment.requireActivity().onBackPressed()
}

