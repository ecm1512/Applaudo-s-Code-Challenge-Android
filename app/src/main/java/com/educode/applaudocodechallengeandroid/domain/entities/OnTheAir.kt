package com.educode.applaudocodechallengeandroid.domain.entities

data class OnTheAir(
    override val id: Int,
    override val name: String,
    override val originalName: String,
    override val overview: String,
    override val posterPath: String,
    override val backdropPath: String,
    override val voteAverage: Double
): Show(id,name,originalName,overview,posterPath,backdropPath,voteAverage)