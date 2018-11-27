package com.cardes.eatournament

import android.app.Activity
import com.cardes.eatournament.db.entity.Team
import com.cardes.eatournament.di.TeamComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamManager @Inject constructor(private val teamComponentBuilder: TeamComponent.Builder) : HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    private lateinit var teamComponent: TeamComponent

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    fun createTeamSession(team: Team) {

        teamComponent = teamComponentBuilder.team(team).build()

        teamComponent.inject(this)
    }

}
