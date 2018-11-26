package com.cardes

import android.app.Activity
import android.app.Application
import com.cardes.eatournament.di.DaggerTournamentComponent
import com.cardes.eatournament.di.TournamentComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class TournamentApplication : Application(), HasActivityInjector {

    private lateinit var component: TournamentComponent

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        component = DaggerTournamentComponent.builder().application(this)
            .build()
        component.inject(this)
    }

}
