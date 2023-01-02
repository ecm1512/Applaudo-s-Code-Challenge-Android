package com.educode.applaudocodechallengeandroid.data.service

import com.google.gson.annotations.SerializedName

data class BaseMovieResponseAiring(
    val page:Int,
    val results: List<AiringToday>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)

data class BaseMovieResponseAir(
    val page:Int,
    val results: List<OnTheAir>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)

data class BaseMovieResponsePopular(
    val page:Int,
    val results: List<Popular>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)

data class BaseMovieResponseTopRated(
    val page:Int,
    val results: List<TopRated>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)
