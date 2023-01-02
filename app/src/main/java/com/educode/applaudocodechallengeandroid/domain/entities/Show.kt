package com.educode.applaudocodechallengeandroid.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
open class Show(
    open val id: Int,
    open val name: String,
    open val originalName: String,
    open val overview: String,
    open val posterPath: String,
    open val backdropPath: String,
    open val voteAverage: Double
): Parcelable

