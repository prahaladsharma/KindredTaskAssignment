package com.kindred.di.component

import android.content.Context
import com.kindred.di.modules.AppModule
import com.kindred.di.modules.CoroutinesModule
import com.kindred.di.modules.NetworkModule
import com.kindred.di.modules.RepositoryModule
import com.kindred.ui.GamesListActivity
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        CoroutinesModule::class
    ]
)
interface AppComponents {
    fun context(): Context

    fun retrofit(): Retrofit

    fun inject(gamesListActivity: GamesListActivity)
}