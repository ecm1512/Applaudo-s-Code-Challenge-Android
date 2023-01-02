package com.educode.applaudocodechallengeandroid.domain.usecases

import android.graphics.Movie
import com.educode.applaudocodechallengeandroid.data.repository.MovieRepository
import com.educode.applaudocodechallengeandroid.domain.entities.TopRated

class GetTopRatedShows(private val movieRepository: MovieRepository) {
    suspend fun invoke(): List<TopRated>{
        return movieRepository.getTopRatedShows()
    }
}