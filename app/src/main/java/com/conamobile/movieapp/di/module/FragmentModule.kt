package com.conamobile.movieapp.di.module

import com.conamobile.movieapp.view.ui.child.ChildFragment
import com.conamobile.movieapp.view.ui.detail.DetailFragment
import com.conamobile.movieapp.view.ui.favorite.FavoriteFragment
import com.conamobile.movieapp.view.ui.find.FindFragment
import com.conamobile.movieapp.view.ui.home.HomeFragment
import com.conamobile.movieapp.view.ui.popular.PopularFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    fun contributeFavoriteFragment(): FavoriteFragment

    @ContributesAndroidInjector
    fun contributeFindFragment(): FindFragment

    @ContributesAndroidInjector
    fun contributePopularFragment(): PopularFragment

    @ContributesAndroidInjector
    fun contributeChildFragment(): ChildFragment

    @ContributesAndroidInjector
    fun contributeDetailFragment(): DetailFragment

}