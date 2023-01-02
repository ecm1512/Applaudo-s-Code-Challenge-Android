package com.educode.applaudocodechallengeandroid.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AiringToday::class, OnTheAir::class, Popular::class, TopRated::class], version = 3)
abstract class MovieDatabase: RoomDatabase() {
    companion object{
        fun build(context: Context) = Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "MovieDb"
        ).build()
    }

    abstract fun airingTodayDao(): AiringTodayDao

    abstract fun onTheAirTodayDao(): OnTheAirTodayDao

    abstract fun popularDao(): PopularDao

    abstract fun topRatedDao(): TopRatedDao


}