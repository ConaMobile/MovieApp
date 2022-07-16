package com.conamobile.movieapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.conamobile.movieapp.domain.pojo.MovieResult

@Database(entities = [(MovieResult::class)], version = 1, exportSchema = false)
abstract class MovieLocalStorage : RoomDatabase() {
    abstract fun movieDao(): Dao
}