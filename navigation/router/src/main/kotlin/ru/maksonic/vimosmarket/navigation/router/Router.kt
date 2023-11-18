package ru.maksonic.vimosmarket.navigation.router

import android.os.Parcelable
import androidx.fragment.app.Fragment

/**
 * @Author maksonic on 16.11.2023
 */
interface Router {
    fun <T : Parcelable> navigateFromCatalogToDetails(fragment: Fragment, data: T)
    fun onBack(fragment: Fragment)
}