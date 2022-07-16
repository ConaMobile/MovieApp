package com.conamobile.movieapp.view.ui.home.adapter

import com.conamobile.movieapp.domain.pojo.MovieResult

interface movieInteractionListener {
    fun onClickRetry()
    fun onMovieClick(movieResult: MovieResult, pos: Int)
}