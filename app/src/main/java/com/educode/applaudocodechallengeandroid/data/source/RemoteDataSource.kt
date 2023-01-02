package com.educode.applaudocodechallengeandroid.data.source

import com.educode.applaudocodechallengeandroid.domain.entities.AiringToday
import com.educode.applaudocodechallengeandroid.domain.entities.OnTheAir
import com.educode.applaudocodechallengeandroid.domain.entities.Popular
import com.educode.applaudocodechallengeandroid.domain.entities.TopRated

interface RemoteDataSource {
    suspend fun getTvAiringTodayShows(apiKey: String): List<AiringToday>
    suspend fun getPopularShows(apiKey: String): List<Popular>
    suspend fun getTopRatedShows(apiKey: String): List<TopRated>
    suspend fun getTvOnTheAirShows(apiKey: String): List<OnTheAir>
}