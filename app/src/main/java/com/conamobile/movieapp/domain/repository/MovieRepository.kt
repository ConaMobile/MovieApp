package com.conamobile.movieapp.domain.repository

import androidx.lifecycle.LiveData
import com.conamobile.movieapp.data.local.Dao
import com.conamobile.movieapp.data.remote.Api
import com.conamobile.movieapp.domain.pojo.MovieDetail
import com.conamobile.movieapp.domain.pojo.MovieQuery
import com.conamobile.movieapp.domain.pojo.MovieResult
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(private val api: Api, private val dao: Dao) {

    suspend fun fetchMovies(map: Map<String, String>, queryTag: QUERYTAG): Response<MovieQuery> {
        return when (queryTag) {
            QUERYTAG.SEARCH -> api.searchMovie(map)
            QUERYTAG.DISCOVER -> api.popularMovie(map)
            QUERYTAG.TRENDING -> api.trendingMovie(map["time_window"] ?: error("week"), map)
        }
    }

    suspend fun movieDetail(movieId: Long, query: String): Response<MovieDetail> {
        return api.movieDetail(movieId, query)
    }

    fun allFavoriteMovie(): LiveData<List<MovieResult>> {
        return dao.allFavorite()
    }

    suspend fun insert(movieResult: MovieResult) {
        return dao.insertFavorite(movieResult)
    }

    suspend fun update(movieResult: MovieResult) {
        return dao.updateFavorite(movieResult)
    }

    suspend fun delete(movieResult: MovieResult) {
        return dao.deleteFavorite(movieResult)
    }

    fun existAsFavorite(id: String): LiveData<List<MovieResult>> {
        return dao.existAsFavorite(id)
    }

    enum class QUERYTAG {
        SEARCH, DISCOVER, TRENDING
    }

}