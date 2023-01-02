package com.educode.applaudocodechallengeandroid.data.service

import com.educode.applaudocodechallengeandroid.data.source.RemoteDataSource
import com.educode.applaudocodechallengeandroid.data.toDomain
import com.educode.applaudocodechallengeandroid.domain.entities.AiringToday
import com.educode.applaudocodechallengeandroid.domain.entities.OnTheAir
import com.educode.applaudocodechallengeandroid.domain.entities.Popular
import com.educode.applaudocodechallengeandroid.domain.entities.Season
import com.educode.applaudocodechallengeandroid.domain.entities.TopRated

class MovieServiceDataSource: RemoteDataSource {
    override suspend fun getTvAiringTodayShows(apiKey: String): List<AiringToday> {
        return MovieClient.service.getTvAiringTodayShows(
            api_key = apiKey
        ).results.map {
            it.toDomain()
        }
    }

    override suspend fun getPopularShows(apiKey: String): List<Popular> {
        return MovieClient.service.getPopularShows(
            api_key = apiKey
        ).results.map {
            it.toDomain()
        }
    }

    override suspend fun getTopRatedShows(apiKey: String): List<TopRated> {
        return MovieClient.service.getTopRatedShows(
            api_key = apiKey
        ).results.map {
            it.toDomain()
        }
    }

    override suspend fun getTvOnTheAirShows(apiKey: String): List<OnTheAir> {
        return MovieClient.service.getTvOnTheAirShows(
            api_key = apiKey
        ).results.map {
            it.toDomain()
        }
    }

    override suspend fun getSeasonByShow(apiKey: String, id: Int): List<Season> {
        return MovieClient.service.getSeasons(
            id = id,
            api_key = apiKey
        ).seasons.map {
            it.toDomain()
        }
    }
}