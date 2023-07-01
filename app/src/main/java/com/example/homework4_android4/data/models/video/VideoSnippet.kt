package com.example.homework4_android4.data.models.video

import com.example.home_4_android_4.data.models.Localized
import com.example.youtube.data.models.Thumbnails
import com.google.gson.annotations.SerializedName

data class VideoSnippet(
    @SerializedName("defaultLanguage")
    val defaultLanguage: String = "",
    @SerializedName("publishedAt")
    val publishedAt: String = "",
    @SerializedName("defaultAudioLanguage")
    val defaultAudioLanguage: String = "",
    @SerializedName("localized")
    val localized: Localized,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("thumbnails")
    val thumbnails: Thumbnails,
    @SerializedName("channelId")
    val channelId: String = "",
    @SerializedName("categoryId")
    val categoryId: String = "",
    @SerializedName("channelTitle")
    val channelTitle: String = "",
    @SerializedName("tags")
    val tags: List<String>?,
    @SerializedName("liveBroadcastContent")
    val liveBroadcastContent: String = ""
)