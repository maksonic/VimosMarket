package ru.maksonic.vimosmarket.feature.onboarding

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import com.bumptech.glide.RequestManager
import dagger.hilt.android.AndroidEntryPoint
import ru.maksonic.vimosmarket.common.ui.BaseActivity
import ru.maksonic.vimosmarket.feature.onboarding.databinding.ActivityOnboardingBinding
import ru.maksonic.vimosmarket.navigation.router.ActivityNavigator
import javax.inject.Inject

/**
 * @Author maksonic on 16.11.2023
 */
@AndroidEntryPoint
class OnboardingActivity : BaseActivity<ActivityOnboardingBinding>() {

    override val bindLayout: (LayoutInflater) -> ActivityOnboardingBinding
        get() = ActivityOnboardingBinding::inflate

    @Inject
    lateinit var imageLoader: RequestManager

    @Inject
    lateinit var activityNavigator: ActivityNavigator

    override fun render(savedInstanceState: Bundle?) {
        initBrandLogo()
        enableEdgeToEdge()
        binding.btnNavigateToCatalog.setOnClickListener {
            activityNavigator.navigateFromOnboardingToCatalog(this)
        }
    }

    private fun initBrandLogo() {
        imageLoader.load(R.drawable.logo_hedgehog).into(binding.imgLogoBrand)
    }

    private fun enableEdgeToEdge() {
        val uiMode = applicationContext.resources?.configuration?.uiMode
        val isDark = when (uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> true
            Configuration.UI_MODE_NIGHT_NO -> false
            else -> false
        }
        val lightBar = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
        val darkBar = SystemBarStyle.dark(Color.TRANSPARENT)

        enableEdgeToEdge(
            statusBarStyle = if (isDark) darkBar else lightBar,
            navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
        )
    }
}