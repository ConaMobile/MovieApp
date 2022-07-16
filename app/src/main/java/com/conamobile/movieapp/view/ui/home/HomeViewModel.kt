package com.conamobile.movieapp.view.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import com.conamobile.movieapp.domain.pagination.MovieDataSourceFactory
import com.conamobile.movieapp.domain.pagination.PaginationState
import com.conamobile.movieapp.domain.repository.MovieRepository
import com.conamobile.movieapp.util.QueryHelper
import com.conamobile.movieapp.view.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(repository: MovieRepository) : BaseViewModel() {

    private var movieDataSourceFactory: MovieDataSourceFactory =
        MovieDataSourceFactory(
            MovieRepository.QUERYTAG.TRENDING,
            QueryHelper.trendingMovies(),
            repository
        )

    val moviePagedLiveData = pagedConfig.let {
        LivePagedListBuilder(movieDataSourceFactory,
            it
        ).build()
    }

    val paginationState: LiveData<PaginationState>? =
        Transformations.switchMap(movieDataSourceFactory.movieDataSourceLiveData) { it.getPaginationState() }

    /**
     * Retry possible last paged request (ie: network issue)
     */
    fun refreshFailedRequest() =
        movieDataSourceFactory.getSource()?.retryFailedQuery()

    /**
     * Refreshes all list after an issue
     */
    fun refreshAllList() =
        movieDataSourceFactory.getSource()?.refresh()


}