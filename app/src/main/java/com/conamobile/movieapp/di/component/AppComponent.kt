package com.conamobile.movieapp.di.component

import com.conamobile.movieapp.App
import com.conamobile.movieapp.di.module.ActivityModule
import com.conamobile.movieapp.di.module.AppModule
import com.conamobile.movieapp.di.module.NetModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    AppModule::class,
    NetModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder?

        fun build(): AppComponent
    }

    override fun inject(application: App)

}


