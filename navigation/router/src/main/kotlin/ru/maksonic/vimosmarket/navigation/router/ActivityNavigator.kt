package ru.maksonic.vimosmarket.navigation.router

import android.app.Activity

/**
 * @Author maksonic on 16.11.2023
 */
interface ActivityNavigator {
    fun navigateFromOnboardingToCatalog(activity: Activity)
}