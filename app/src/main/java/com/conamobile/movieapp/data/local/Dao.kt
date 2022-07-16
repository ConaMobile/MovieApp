package com.conamobile.movieapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.conamobile.movieapp.domain.pojo.MovieResult

@Dao
interface Dao {

    @Query("SELECT * FROM MovieLocal")
    fun allFavorite(): LiveData<List<MovieResult>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(movieLocal: MovieResult) //

    @Update
    fun updateFavorite(movieLocal: MovieResult) //

    @Delete
    fun deleteFavorite(movieLocal: MovieResult) //

    @Query("SELECT * FROM MovieLocal WHERE id=:id LIMIT 1")
    fun existAsFavorite(id: String): LiveData<List<MovieResult>>

}