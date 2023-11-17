package ru.maksonic.vimosmarket

import android.content.Context
import ru.maksonic.vimosmarket.common.ui.ResourceProvider
import javax.inject.Inject

/**
 * @Author maksonic on 17.11.2023
 */
class ResourceProviderCore @Inject constructor(private val context: Context) : ResourceProvider {
    override fun getString(id: Int, vararg formatArgs: Any?) =
        context.getString(id, *formatArgs)
}