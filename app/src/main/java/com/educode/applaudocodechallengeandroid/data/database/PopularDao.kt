package com.educode.applaudocodechallengeandroid.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface PopularDao {

    @Query("SELECT * FROM Popular")
    fun getPopular(): List<Popular>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePopular(popular: List<Popular>)

    @Query("SELECT COUNT(*) FROM Popular")
    fun movieCount(): Int
}