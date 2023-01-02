package com.educode.applaudocodechallengeandroid.domain.entities


data class Season(
    val id: Int,
    val name: String,
    val number: Int,
    val overview: String?,
    val posterPath: String
)
