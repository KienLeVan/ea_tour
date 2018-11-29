package com.cardes.eatournament.viewmodel

import android.arch.lifecycle.ViewModel
import com.cardes.eatournament.SchedulerProvider
import com.cardes.eatournament.db.entity.Player
import com.cardes.eatournament.db.entity.Team
import com.cardes.eatournament.usecase.GetPlayersFromTeamUseCase
import com.cardes.eatournament.usecase.GetTeamUseCase
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class TeamPlayerListViewModel @Inject constructor(private val getPlayersFromTeamUseCase: GetPlayersFromTeamUseCase,
                                                  private val getTeamUseCase: GetTeamUseCase,
                                                  private val schedulerProvider: SchedulerProvider) : ViewModel() {

    fun getPlayersFromTeam(): Flowable<List<Player>> {
        return getPlayersFromTeamUseCase.execute()
            .subscribeOn(schedulerProvider.ioScheduler())
            .observeOn(schedulerProvider.uiScheduler())
    }

    fun getTeam(): Single<Team> {
        return getTeamUseCase.execute()
            .subscribeOn(schedulerProvider.ioScheduler())
            .observeOn(schedulerProvider.uiScheduler())
    }

}
