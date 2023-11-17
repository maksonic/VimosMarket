package ru.maksonic.vimosmarket.common.ui

import androidx.annotation.StringRes

/**
 * @Author maksonic on 17.11.2023
 */
interface ResourceProvider {
    fun getString(@StringRes id: Int, vararg formatArgs: Any?): String
}
