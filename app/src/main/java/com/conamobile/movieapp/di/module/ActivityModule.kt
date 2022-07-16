package com.conamobile.movieapp.di.module


import com.conamobile.movieapp.view.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    fun contributeHomeActivity(): HomeActivity
}