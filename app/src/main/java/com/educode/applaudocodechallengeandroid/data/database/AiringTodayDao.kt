package com.educode.applaudocodechallengeandroid.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface AiringTodayDao {

    @Query("SELECT * FROM AiringToday")
    fun getAiringToday(): List<AiringToday>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAiringToday(airingToday: List<AiringToday>)

    @Query("SELECT COUNT(*) FROM AiringToday")
    fun movieCount(): Int
}