package com.educode.applaudocodechallengeandroid.domain.usecases

import com.educode.applaudocodechallengeandroid.data.repository.MovieRepository
import com.educode.applaudocodechallengeandroid.domain.entities.Popular

class GetPopularShows(private val movieRepository: MovieRepository) {
    suspend fun invoke(): List<Popular>{
        return movieRepository.getPopularShows()
    }
}