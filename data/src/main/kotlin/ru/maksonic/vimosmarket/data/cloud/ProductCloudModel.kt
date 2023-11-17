package ru.maksonic.vimosmarket.data.cloud

import com.google.gson.annotations.SerializedName

/**
 * @Author maksonic on 17.11.2023
 */
internal typealias CloudProducts = List<ProductCloudModel>

data class ProductCloudModel(
    @SerializedName("gcode") val code: Long,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Long,
    @SerializedName("img_preview") val imageLink: String?
)