package com.educode.applaudocodechallengeandroid.data.repository

import com.educode.applaudocodechallengeandroid.data.source.LocalDataSource
import com.educode.applaudocodechallengeandroid.data.source.RemoteDataSource
import com.educode.applaudocodechallengeandroid.domain.entities.AiringToday
import com.educode.applaudocodechallengeandroid.domain.entities.OnTheAir
import com.educode.applaudocodechallengeandroid.domain.entities.Popular
import com.educode.applaudocodechallengeandroid.domain.entities.TopRated

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val apiKey: String
) {
    suspend fun getTvAiringTodayShows(): List<AiringToday> {
        if(localDataSource.isEmptyTvAiringTodayShows()){
            val movies = remoteDataSource.getTvAiringTodayShows(apiKey)
            localDataSource.saveTvAiringTodayShows(movies)
        }
        return localDataSource.getTvAiringTodayShows()
    }

    suspend fun getPopularShows(): List<Popular>{
        if(localDataSource.isEmptyPopularShows()){
            val movies = remoteDataSource.getPopularShows(apiKey)
            localDataSource.savePopularShows(movies)
        }
        return localDataSource.getPopularShows()
    }

    suspend fun getTopRatedShows(): List<TopRated>{
        if(localDataSource.isEmptyTopRatedShows()){
            val movies = remoteDataSource.getTopRatedShows(apiKey)
            localDataSource.saveTopRatedShows(movies)
        }
        return localDataSource.getTopRatedShows()
    }

    suspend fun getTvOnTheAirShows(): List<OnTheAir>{
        if(localDataSource.isEmptyTvOnTheAirShows()){
            val movies = remoteDataSource.getTvOnTheAirShows(apiKey)
            localDataSource.saveTvOnTheAirShows(movies)
        }
        return localDataSource.getTvOnTheAirShows()
    }
}