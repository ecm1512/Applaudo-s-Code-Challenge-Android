package com.educode.applaudocodechallengeandroid.domain.usecases

import com.educode.applaudocodechallengeandroid.data.repository.SeasonRepository
import com.educode.applaudocodechallengeandroid.domain.entities.Season

class GetSeasonsByShow(private val seasonRepository: SeasonRepository) {
    suspend fun invoke(id: Int): List<Season>{
        return seasonRepository.getSeasons(id)
    }
}