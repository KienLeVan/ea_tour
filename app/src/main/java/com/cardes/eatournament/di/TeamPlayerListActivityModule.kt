package com.cardes.eatournament.di

import android.arch.lifecycle.ViewModel
import com.cardes.eatournament.usecase.GetPlayersFromTeamUseCase
import com.cardes.eatournament.usecase.GetPlayersFromTeamUseCaseImpl
import com.cardes.eatournament.viewmodel.TeamPlayerListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface TeamPlayerListActivityModule {

    @Binds
    @IntoMap
    @ActivityScope
    @ViewModelKey(TeamPlayerListViewModel::class)
    fun teamPlayerListViewModel(teamPlayerListViewModel: TeamPlayerListViewModel): ViewModel

    @Binds
    @ActivityScope
    fun getPlayersFromTeamUseCase(getPlayersFromTeamUseCase: GetPlayersFromTeamUseCaseImpl): GetPlayersFromTeamUseCase

}
