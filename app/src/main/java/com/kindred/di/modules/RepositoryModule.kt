package com.kindred.di.modules

import com.kindred.api.ApiService
import com.kindred.data_source.remote.RemoteDataSourceImpl
import com.kindred.di.IoDispatcher
import com.kindred.repository.AppRepositoryImpl
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
class RepositoryModule {


    @Provides
    @Singleton
    fun provideAppRepository(
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
        api: ApiService
    ): AppRepositoryImpl {
        val userDataSource = RemoteDataSourceImpl(api, ioDispatcher)
        return AppRepositoryImpl(userDataSource,ioDispatcher)
    }
}