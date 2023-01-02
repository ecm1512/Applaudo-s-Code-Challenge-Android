package com.educode.applaudocodechallengeandroid.data

import com.educode.applaudocodechallengeandroid.data.database.AiringToday
import com.educode.applaudocodechallengeandroid.data.database.Popular
import com.educode.applaudocodechallengeandroid.data.database.TopRated
import com.educode.applaudocodechallengeandroid.data.database.OnTheAir
import com.educode.applaudocodechallengeandroid.data.service.Season

fun AiringToday.toDomain(): com.educode.applaudocodechallengeandroid.domain.entities.AiringToday =
    com.educode.applaudocodechallengeandroid.domain.entities.AiringToday(
        id,
        name,
        originalName,
        overview,
        posterPath,
        backdropPath,
        voteAverage
    )

fun com.educode.applaudocodechallengeandroid.data.service.AiringToday.toDomain(): com.educode.applaudocodechallengeandroid.domain.entities.AiringToday =
    com.educode.applaudocodechallengeandroid.domain.entities.AiringToday(
        id,
        name,
        originalName,
        overview,
        posterPath,
        backdropPath ?: "",
        voteAverage
    )

fun com.educode.applaudocodechallengeandroid.domain.entities.AiringToday.toRoomEntity(): AiringToday = AiringToday(
    id,
    name,
    originalName,
    overview,
    posterPath,
    backdropPath,
    voteAverage
)

fun OnTheAir.toDomain(): com.educode.applaudocodechallengeandroid.domain.entities.OnTheAir =
    com.educode.applaudocodechallengeandroid.domain.entities.OnTheAir(
        id,
        name,
        originalName,
        overview,
        posterPath,
        backdropPath,
        voteAverage
    )

fun com.educode.applaudocodechallengeandroid.data.service.OnTheAir.toDomain(): com.educode.applaudocodechallengeandroid.domain.entities.OnTheAir =
    com.educode.applaudocodechallengeandroid.domain.entities.OnTheAir(
        id,
        name,
        originalName,
        overview,
        posterPath,
        backdropPath ?: "",
        voteAverage
    )

fun com.educode.applaudocodechallengeandroid.domain.entities.OnTheAir.toRoomEntity(): OnTheAir = OnTheAir(
    id,
    name,
    originalName,
    overview,
    posterPath,
    backdropPath,
    voteAverage
)

fun Popular.toDomain(): com.educode.applaudocodechallengeandroid.domain.entities.Popular =
    com.educode.applaudocodechallengeandroid.domain.entities.Popular(
        id,
        name,
        originalName,
        overview,
        posterPath,
        backdropPath,
        voteAverage
    )

fun com.educode.applaudocodechallengeandroid.data.service.Popular.toDomain(): com.educode.applaudocodechallengeandroid.domain.entities.Popular =
    com.educode.applaudocodechallengeandroid.domain.entities.Popular(
        id,
        name,
        originalName,
        overview,
        posterPath,
        backdropPath ?: "",
        voteAverage
    )

fun com.educode.applaudocodechallengeandroid.domain.entities.Popular.toRoomEntity(): Popular = Popular(
    id,
    name,
    originalName,
    overview,
    posterPath,
    backdropPath,
    voteAverage
)

fun TopRated.toDomain(): com.educode.applaudocodechallengeandroid.domain.entities.TopRated =
    com.educode.applaudocodechallengeandroid.domain.entities.TopRated(
        id,
        name,
        originalName,
        overview,
        posterPath,
        backdropPath,
        voteAverage
    )

fun com.educode.applaudocodechallengeandroid.data.service.TopRated.toDomain(): com.educode.applaudocodechallengeandroid.domain.entities.TopRated =
    com.educode.applaudocodechallengeandroid.domain.entities.TopRated(
        id,
        name,
        originalName,
        overview,
        posterPath,
        backdropPath ?: "",
        voteAverage
    )

fun com.educode.applaudocodechallengeandroid.domain.entities.TopRated.toRoomEntity(): TopRated = TopRated(
    id,
    name,
    originalName,
    overview,
    posterPath,
    backdropPath,
    voteAverage
)

fun Season.toDomain(): com.educode.applaudocodechallengeandroid.domain.entities.Season = com.educode.applaudocodechallengeandroid.domain.entities.Season(
    id,
    name,
    number,
    overview ?: "",
    posterPath
)