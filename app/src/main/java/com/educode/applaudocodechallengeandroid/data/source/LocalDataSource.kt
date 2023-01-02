package com.educode.applaudocodechallengeandroid.data.source

import com.educode.applaudocodechallengeandroid.domain.entities.AiringToday
import com.educode.applaudocodechallengeandroid.domain.entities.OnTheAir
import com.educode.applaudocodechallengeandroid.domain.entities.Popular
import com.educode.applaudocodechallengeandroid.domain.entities.TopRated

interface LocalDataSource {
    suspend fun getTvAiringTodayShows(): List<AiringToday>
    suspend fun getPopularShows(): List<Popular>
    suspend fun getTopRatedShows(): List<TopRated>
    suspend fun getTvOnTheAirShows(): List<OnTheAir>

    suspend fun saveTvAiringTodayShows(airingToday: List<AiringToday>)
    suspend fun savePopularShows(popular: List<Popular>)
    suspend fun saveTopRatedShows(topRated: List<TopRated>)
    suspend fun saveTvOnTheAirShows(onTheAir: List<OnTheAir>)

    suspend fun isEmptyTvAiringTodayShows(): Boolean
    suspend fun isEmptyPopularShows(): Boolean
    suspend fun isEmptyTopRatedShows(): Boolean
    suspend fun isEmptyTvOnTheAirShows(): Boolean
}