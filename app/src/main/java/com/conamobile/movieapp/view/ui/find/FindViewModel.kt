package com.conamobile.movieapp.view.ui.find

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import com.conamobile.movieapp.domain.pagination.MovieDataSourceFactory
import com.conamobile.movieapp.domain.pagination.PaginationState
import com.conamobile.movieapp.domain.repository.MovieRepository
import com.conamobile.movieapp.view.base.BaseViewModel
import javax.inject.Inject

class FindViewModel @Inject constructor(private val repository: MovieRepository) : BaseViewModel() {

    private var movieDataSourceFactory: MovieDataSourceFactory =
        MovieDataSourceFactory(
            MovieRepository.QUERYTAG.SEARCH,
            initParams(),
            repository
        )

    private fun initParams(): HashMap<String, String> {
        val hashMap = HashMap<String, String>()
        hashMap["query"] = ""
        return hashMap
    }

    val moviePagedLiveData = pagedConfig.let {
        LivePagedListBuilder(
            movieDataSourceFactory,
            it
        ).build()
    }

    val paginationState: LiveData<PaginationState>? =
        Transformations.switchMap(movieDataSourceFactory.movieDataSourceLiveData) { it.getPaginationState() }

    fun searchMovieByName(query: String) {
        val querySearch = HashMap<String, String>()
        if (query == movieDataSourceFactory.getLastQueryParams()["query"]) return
        querySearch["query"] = query
        movieDataSourceFactory.updateQueryParams(querySearch, MovieRepository.QUERYTAG.SEARCH)
    }

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