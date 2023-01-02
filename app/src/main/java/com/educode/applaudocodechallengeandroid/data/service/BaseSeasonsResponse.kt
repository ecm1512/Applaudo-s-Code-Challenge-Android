package com.educode.applaudocodechallengeandroid.data.service

import com.google.gson.annotations.SerializedName

data class BaseSeasonsResponse(
    @SerializedName("id")
    val idShow: Int,
    val seasons: List<Season>
)

data class Season(
    val id: Int,
    val name: String,
    @SerializedName("episode_count")
    val number: Int,
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String
)
