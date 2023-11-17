package ru.maksonic.vimosmarket.feature.onboarding

import android.os.Bundle
import android.view.LayoutInflater
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
        binding.btnNavigateToCatalog.setOnClickListener {
            activityNavigator.navigateFromOnboardingToCatalog(this)
        }
    }

    private fun initBrandLogo() {
        imageLoader.load(R.drawable.logo_hedgehog).into(binding.imgLogoBrand)
    }
}