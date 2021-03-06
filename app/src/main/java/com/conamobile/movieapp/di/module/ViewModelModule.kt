package com.conamobile.movieapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.conamobile.movieapp.common.ViewModelFactory
import com.conamobile.movieapp.di.key.ViewModelKey
import com.conamobile.movieapp.view.ui.child.ChildViewModel
import com.conamobile.movieapp.view.ui.detail.DetailViewModel
import com.conamobile.movieapp.view.ui.favorite.FavoriteViewModel
import com.conamobile.movieapp.view.ui.find.FindViewModel
import com.conamobile.movieapp.view.ui.home.HomeViewModel
import com.conamobile.movieapp.view.ui.popular.PopularViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(homeViewModel: HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    fun bindFavoriteViewModel(favoriteViewModel: FavoriteViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FindViewModel::class)
    fun bindFindViewModel(findViewModel: FindViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun bindDetailViewModel(detailViewModel: DetailViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PopularViewModel::class)
    fun bindPopularViewModel(popularViewModel: PopularViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChildViewModel::class)
    fun bindChildViewModel(childViewModel: ChildViewModel) : ViewModel


    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}