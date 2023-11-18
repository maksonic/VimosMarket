package ru.maksonic.vimosmarket.common.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import androidx.lifecycle.flowWithLifecycle
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * @Author maksonic on 16.11.2023
 */
abstract class BaseScreen<VB : ViewBinding> : Fragment() {
    private var _binding: VB? = null
    abstract val initBinding: (LayoutInflater, ViewGroup?, Boolean) -> VB

    protected val binding: VB
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = initBinding.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applySystemBarsInsets()
        setNavigationBarColor(requireContext().getColor(R.color.background))
        onLaunch(savedInstanceState)
        render(savedInstanceState)
    }

    private fun applySystemBarsInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.updatePadding(top = insets.top, bottom = insets.bottom)
            WindowInsetsCompat.CONSUMED
        }
    }

    protected fun <T> StateFlow<T>.handle(onState: (state: T) -> Unit) = lifecycleScope.launch {
        this@handle.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .collect { state -> onState(state) }
    }

    protected fun showNavigateBackIcon() {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    protected fun hideNavigationBackIcon() {
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
    }

    protected fun setNavigationBarColor(@ColorInt colorId: Int) {
        requireActivity().window.navigationBarColor = colorId
    }

    protected fun setStatusBarColor(@ColorInt colorId: Int) {
        requireActivity().window.statusBarColor = colorId
    }

    open fun onLaunch(savedInstanceState: Bundle?) {}

    abstract fun render(savedInstanceState: Bundle?)

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}