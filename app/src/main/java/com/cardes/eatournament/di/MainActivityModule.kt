package com.cardes.eatournament.di

import android.arch.lifecycle.ViewModel
import com.cardes.eatournament.usecase.GetTeamsUseCase
import com.cardes.eatournament.usecase.GetTeamsUseCaseImpl
import com.cardes.eatournament.viewmodel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun mainActivityViewModel(mainActivityViewModel: MainActivityViewModel) : ViewModel

    @Binds
    fun getTeamsUseCase(getTeamsUseCase: GetTeamsUseCaseImpl) : GetTeamsUseCase

}
