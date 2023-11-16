package ru.maksonic.vimosmarket

import android.app.Activity
import android.content.Intent
import ru.maksonic.vimosmarket.navigation.router.ActivityNavigator
import javax.inject.Inject

/**
 * @Author maksonic on 16.11.2023
 */
class ActivityNavigatorCore @Inject constructor() : ActivityNavigator {
    override fun navigateFromOnboardingToCatalog(activity: Activity) = with(activity) {
        startActivity(Intent(this.baseContext, MainActivity::class.java))
    }
}