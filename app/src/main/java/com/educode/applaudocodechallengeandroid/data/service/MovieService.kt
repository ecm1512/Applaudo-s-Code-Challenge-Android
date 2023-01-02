package com.educode.applaudocodechallengeandroid.data.service

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("tv/top_rated")
    suspend fun getTopRatedShows(
        @Query("page")
        page: Int = 1,
        @Query("language")
        language: String = "es",
        @Query("api_key")
        api_key: String
    ): BaseMovieResponseTopRated

    @GET("tv/popular")
    suspend fun getPopularShows(
        @Query("page")
        page: Int = 1,
        @Query("language")
        language: String = "es",
        @Query("api_key")
        api_key: String
    ): BaseMovieResponsePopular

    @GET("tv/on_the_air")
    suspend fun getTvOnTheAirShows(
        @Query("page")
        page: Int = 1,
        @Query("language")
        language: String = "es",
        @Query("api_key")
        api_key: String
    ): BaseMovieResponseAir

    @GET("tv/airing_today")
    suspend fun getTvAiringTodayShows(
        @Query("page")
        page: Int = 1,
        @Query("language")
        language: String = "es",
        @Query("api_key")
        api_key: String
    ): BaseMovieResponseAiring

    @GET("tv/{id}")
    suspend fun getSeasons(
        @Path("id")
        id: Int,
        @Query("page")
        page: Int = 1,
        @Query("language")
        language: String = "es",
        @Query("api_key")
        api_key: String
    ): BaseSeasonsResponse
}