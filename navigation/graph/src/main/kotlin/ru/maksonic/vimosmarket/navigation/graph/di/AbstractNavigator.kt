package ru.maksonic.vimosmarket.navigation.graph.di

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

/**
 * @Author maksonic on 16.11.2023
 */
abstract class AbstractNavigator {
    fun Fragment.navigate(
        actionId: Int,
        argKey: String,
        hostId: Int? = null,
        data: Parcelable? = null
    ) {
        val navController = if (hostId == null) {
            findNavController()
        } else {
            Navigation.findNavController(requireActivity(), hostId)
        }
        val bundle = Bundle().apply { putParcelable(argKey, data) }
        val action = navController.currentDestination?.getAction(actionId)

        if (action != null && navController.currentDestination?.id != action.destinationId) {
            navController.navigate(actionId, bundle)
        }
    }
}