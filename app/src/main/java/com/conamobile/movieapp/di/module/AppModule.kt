package com.conamobile.movieapp.di.module

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.conamobile.movieapp.App
import com.conamobile.movieapp.data.local.Dao
import com.conamobile.movieapp.data.local.MovieLocalStorage
import com.conamobile.movieapp.data.remote.Api
import com.conamobile.movieapp.domain.repository.MovieRepository
import com.conamobile.movieapp.util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [(ViewModelModule::class)])
class AppModule {

    @Provides
    internal fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: Api, dao: Dao): MovieRepository {
        return MovieRepository(api, dao)
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): MovieLocalStorage = Room.databaseBuilder(
        context,
        MovieLocalStorage::class.java, Constants.DATABASE
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(
        database: MovieLocalStorage,
    ): Dao = database.movieDao()

    @Provides
    @Singleton
    fun providePreference(
        context: Context,
    ): SharedPreferences = context.getSharedPreferences(Constants.PREFERENCE, Context.MODE_PRIVATE)

}