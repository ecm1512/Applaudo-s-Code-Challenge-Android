package com.educode.applaudocodechallengeandroid.data.database

import com.educode.applaudocodechallengeandroid.data.source.LocalDataSource
import com.educode.applaudocodechallengeandroid.data.toDomain
import com.educode.applaudocodechallengeandroid.data.toRoomEntity
import com.educode.applaudocodechallengeandroid.domain.entities.AiringToday
import com.educode.applaudocodechallengeandroid.domain.entities.OnTheAir
import com.educode.applaudocodechallengeandroid.domain.entities.Popular
import com.educode.applaudocodechallengeandroid.domain.entities.TopRated
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieDbDataSource(db: MovieDatabase): LocalDataSource {

    private val airingTodayDao = db.airingTodayDao()

    private val onTheAirTodayDao = db.onTheAirTodayDao()

    private val popularDao = db.popularDao()

    private val topRatedDao = db.topRatedDao()

    override suspend fun getTvAiringTodayShows(): List<AiringToday> {
        return withContext(Dispatchers.IO){
            airingTodayDao.getAiringToday().map{
                it.toDomain()
            }
        }
    }

    override suspend fun saveTvAiringTodayShows(airingToday: List<AiringToday>) {
        withContext(Dispatchers.IO){
            airingTodayDao.saveAiringToday(airingToday.map {
                it.toRoomEntity()
            })
        }
    }

    override suspend fun isEmptyTvAiringTodayShows(): Boolean {
        return withContext(Dispatchers.IO){
            airingTodayDao.movieCount() <= 0
        }
    }

    override suspend fun getPopularShows(): List<Popular> {
        return withContext(Dispatchers.IO){
            popularDao.getPopular().map{
                it.toDomain()
            }
        }
    }

    override suspend fun savePopularShows(popular: List<Popular>) {
        withContext(Dispatchers.IO){
            popularDao.savePopular(popular.map {
                it.toRoomEntity()
            })
        }
    }

    override suspend fun isEmptyPopularShows(): Boolean {
        return withContext(Dispatchers.IO){
            popularDao.movieCount() <= 0
        }
    }

    override suspend fun getTopRatedShows(): List<TopRated> {
        return withContext(Dispatchers.IO){
            topRatedDao.getTopRated().map{
                it.toDomain()
            }
        }
    }

    override suspend fun saveTopRatedShows(topRated: List<TopRated>) {
        return withContext(Dispatchers.IO){
            topRatedDao.saveTopRated(topRated.map{
                it.toRoomEntity()
            })
        }
    }

    override suspend fun isEmptyTopRatedShows(): Boolean {
        return withContext(Dispatchers.IO){
            topRatedDao.movieCount() <= 0
        }
    }

    override suspend fun getTvOnTheAirShows(): List<OnTheAir> {
        return withContext(Dispatchers.IO){
            onTheAirTodayDao.getOnTheAir().map{
                it.toDomain()
            }
        }
    }

    override suspend fun saveTvOnTheAirShows(onTheAir: List<OnTheAir>) {
        return withContext(Dispatchers.IO){
            onTheAirTodayDao.saveOnTheAir(onTheAir.map{
                it.toRoomEntity()
            })
        }
    }

    override suspend fun isEmptyTvOnTheAirShows(): Boolean {
        return withContext(Dispatchers.IO){
            onTheAirTodayDao.movieCount() <= 0
        }
    }
}