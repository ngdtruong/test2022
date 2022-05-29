package com.example.test2022.model

import com.google.gson.annotations.SerializedName

data class MediaList(
    @SerializedName("fileName") val fileName: String,
    @SerializedName("md5") val md5: String,
    @SerializedName("orderId") val orderId: Int,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String,
    var imageUrl: String)
