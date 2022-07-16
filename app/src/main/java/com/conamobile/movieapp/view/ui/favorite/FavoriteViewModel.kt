package com.conamobile.movieapp.view.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.conamobile.movieapp.data.Resource
import com.conamobile.movieapp.data.Status
import com.conamobile.movieapp.domain.pojo.MovieResult
import com.conamobile.movieapp.domain.repository.MovieRepository
import com.conamobile.movieapp.view.base.BaseViewModel
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val repository: MovieRepository) :
    BaseViewModel() {


    fun getMovieFavorites(): LiveData<Resource<List<MovieResult>>> {
        progressState.postValue(true)
        return Transformations.map(repository.allFavoriteMovie()) {
            progressState.postValue(false)
            Resource(Status.SUCCESS, it, null)
        }
    }

    fun getProgressState(): LiveData<Boolean> = progressState

}