package com.educode.applaudocodechallengeandroid.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OnTheAir(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val originalName: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val voteAverage: Double
)
