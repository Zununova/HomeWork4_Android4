package com.example.homework4_android4.data.models.category

import com.google.gson.annotations.SerializedName

data class Snippet(

    @SerializedName("channelId")
    val channelId : String,
    @SerializedName("title")
    val title: String,
    @SerializedName("assignable")
    val assignable : Boolean
)