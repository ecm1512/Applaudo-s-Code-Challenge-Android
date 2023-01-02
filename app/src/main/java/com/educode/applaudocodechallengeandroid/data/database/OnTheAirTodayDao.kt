package com.educode.applaudocodechallengeandroid.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface OnTheAirTodayDao {

    @Query("SELECT * FROM OnTheAir")
    fun getOnTheAir(): List<OnTheAir>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveOnTheAir(onTheAir: List<OnTheAir>)

    @Query("SELECT COUNT(*) FROM OnTheAir")
    fun movieCount(): Int
}