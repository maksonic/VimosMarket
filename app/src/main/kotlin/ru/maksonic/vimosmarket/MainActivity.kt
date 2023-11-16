package ru.maksonic.vimosmarket

import android.os.Bundle
import android.view.LayoutInflater
import dagger.hilt.android.AndroidEntryPoint
import ru.maksonic.vimosmarket.common.ui.BaseActivity
import ru.maksonic.vimosmarket.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindLayout: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun render(savedInstanceState: Bundle?) {

    }
}