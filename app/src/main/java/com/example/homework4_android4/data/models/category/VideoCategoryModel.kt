package com.example.homework4_android4.data.models.category

import com.google.gson.annotations.SerializedName

data class VideoCategoryModel(
    @SerializedName("kind")
    val kind: String,

    @SerializedName("etag")
    val etag: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("snippet")
    val snippet: Snippet
)

