package com.educode.applaudocodechallengeandroid.domain.usecases

import com.educode.applaudocodechallengeandroid.data.repository.MovieRepository
import com.educode.applaudocodechallengeandroid.domain.entities.AiringToday

class GetTvAiringTodayShows(private val movieRepository: MovieRepository) {
    suspend fun invoke(): List<AiringToday>{
        return movieRepository.getTvAiringTodayShows()
    }
}