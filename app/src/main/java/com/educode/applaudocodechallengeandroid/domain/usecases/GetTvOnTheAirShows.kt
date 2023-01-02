package com.educode.applaudocodechallengeandroid.domain.usecases

import android.graphics.Movie
import com.educode.applaudocodechallengeandroid.data.repository.MovieRepository
import com.educode.applaudocodechallengeandroid.domain.entities.OnTheAir

class GetTvOnTheAirShows(private val movieRepository: MovieRepository) {
    suspend fun invoke(): List<OnTheAir>{
        return movieRepository.getTvOnTheAirShows()
    }
}