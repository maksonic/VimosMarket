package ru.maksonic.vimosmarket.feature.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.maksonic.vimosmarket.common.ui.BaseScreen
import ru.maksonic.vimosmarket.feature.onboarding.databinding.ScreenOnboardingBinding

/**
 * @Author maksonic on 16.11.2023
 */
class OnboardingScreen : BaseScreen<ScreenOnboardingBinding>() {
    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> ScreenOnboardingBinding
        get() = ScreenOnboardingBinding::inflate

    override fun render(savedInstanceState: Bundle?) {

    }
}