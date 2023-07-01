package com.example.youtube.data.models

import com.example.home_4_android_4.data.models.High
import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("high")
    val standard: High
)