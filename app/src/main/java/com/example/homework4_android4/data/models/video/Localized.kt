package com.example.home_4_android_4.data.models

import com.google.gson.annotations.SerializedName

data class Localized(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("title")
    val title: String = ""
)