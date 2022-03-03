package com.kindred.di.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kindred.ui.GamesListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * Module used to define the connection between the framework's [ViewModelProvider.Factory] and
 * our own implementation: [DaggerViewModelFactory].
 */
@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(GamesListViewModel::class)
    abstract fun bindGamesListVM(gamesListViewModel: GamesListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

}