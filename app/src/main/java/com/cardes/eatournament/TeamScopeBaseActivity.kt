package com.cardes.eatournament

import android.os.Bundle
import com.cardes.TournamentApplication
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class TeamScopeBaseActivity : BaseActivity() {

    @Inject
    lateinit var teamManager: TeamManager

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

}
