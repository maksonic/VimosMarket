package ru.maksonic.vimosmarket.navigation.graph.di

import android.os.Build
import android.os.Parcelable
import androidx.fragment.app.Fragment

/**
 * @Author maksonic on 16.11.2023
 */
inline fun <reified T : Parcelable> getArgParcelable(fragment: Fragment, key: String) =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        fragment.arguments?.getParcelable(key, T::class.java)
    } else {
        fragment.arguments?.getParcelable(key)
    }