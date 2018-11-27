package com.cardes

import android.app.Activity
import android.app.Application
import android.os.UserManager
import com.cardes.eatournament.TeamManager
import com.cardes.eatournament.di.DaggerTournamentComponent
import com.cardes.eatournament.di.TournamentComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class TournamentApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var component: TournamentComponent

    @Inject
    lateinit var teamManager: TeamManager

    override fun activityInjector(): AndroidInjector<Activity> = teamManager.activityInjector()

    override fun onCreate() {
        super.onCreate()
        component = DaggerTournamentComponent.builder().application(this)
            .build()
        component.inject(this)
    }

}
