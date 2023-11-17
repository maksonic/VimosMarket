package ru.maksonic.vimosmarket.common.ui

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

/**
 * @Author maksonic on 16.11.2023
 */
abstract class BaseActivity<VB : ViewBinding> : FragmentActivity() {
    private var _binding: VB? = null
    abstract val bindLayout: (LayoutInflater) -> VB

    protected val binding: VB
        get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        _binding = bindLayout.invoke(layoutInflater)
        setContentView(binding.root)
        applySystemBarsInsets()
        render(savedInstanceState)
    }

    abstract fun render(savedInstanceState: Bundle?)

    private fun applySystemBarsInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.updatePadding(top = insets.top, bottom = insets.bottom)
            WindowInsetsCompat.CONSUMED
        }
    }

    private fun enableEdgeToEdge() {
        val uiMode = applicationContext.resources?.configuration?.uiMode
        val isDark = when (uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> true
            Configuration.UI_MODE_NIGHT_NO -> false
            else -> false
        }

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = Color.TRANSPARENT,
                darkScrim = Color.TRANSPARENT,
                detectDarkMode = { isDark }
            ),
            navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
        )
    }
}