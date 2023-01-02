package com.educode.applaudocodechallengeandroid.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface TopRatedDao {

    @Query("SELECT * FROM TopRated")
    fun getTopRated(): List<TopRated>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTopRated(topRated: List<TopRated>)

    @Query("SELECT COUNT(*) FROM TopRated")
    fun movieCount(): Int
}