package com.example.homework4_android4.data.models.video

import com.google.gson.annotations.SerializedName

data class VideoModel(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("snippet")
    val snippet: VideoSnippet
)
