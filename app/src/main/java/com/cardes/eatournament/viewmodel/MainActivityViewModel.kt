package com.cardes.eatournament.viewmodel

import android.arch.lifecycle.ViewModel
import com.cardes.eatournament.SchedulerProvider
import com.cardes.eatournament.db.entity.Team
import com.cardes.eatournament.usecase.GetTeamsUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val getTeamsUseCase: GetTeamsUseCase,
                                                private val schedulerProvider: SchedulerProvider) : ViewModel() {

    fun getTeams(): Flowable<List<Team>> {
        return getTeamsUseCase.execute()
            .subscribeOn(schedulerProvider.ioScheduler())
            .observeOn(schedulerProvider.uiScheduler())
    }

}
