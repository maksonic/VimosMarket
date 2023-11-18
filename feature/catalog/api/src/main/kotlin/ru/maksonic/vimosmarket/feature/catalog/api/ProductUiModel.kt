package ru.maksonic.vimosmarket.feature.catalog.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @Author maksonic on 16.11.2023
 */
@Parcelize
data class ProductUiModel(
    val name: String,
    val price: Long,
    val code: Long,
    val imageLink: String?
): Parcelable {
    companion object {
        val Default = ProductUiModel(
            name = "",
            price = 0,
            code = 0,
            imageLink = null
        )
    }
}