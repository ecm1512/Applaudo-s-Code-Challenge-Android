package com.educode.applaudocodechallengeandroid.data.service

import com.google.gson.annotations.SerializedName

data class Popular(
    val id: Int,
    val name: String,
    @SerializedName("original_name")
    val originalName: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("vote_average")
    val voteAverage: Double
)
