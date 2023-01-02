package com.educode.applaudocodechallengeandroid.data.repository

import com.educode.applaudocodechallengeandroid.data.source.LocalDataSource
import com.educode.applaudocodechallengeandroid.data.source.RemoteDataSource
import com.educode.applaudocodechallengeandroid.domain.entities.Season

class SeasonRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val apiKey: String
) {

    suspend fun getSeasons(id: Int): List<Season> {
        /*if(localDataSource.isEmptySeasonByShow(id)){
            val movies = remoteDataSource.getSeasonByShow(apiKey)
            localDataSource.saveTvAiringTodayShows(movies)
        }
        return localDataSource.getTvAiringTodayShows()*/
        return remoteDataSource.getSeasonByShow(apiKey, id)
    }
}