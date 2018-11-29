package com.cardes.eatournament.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.cardes.eatournament.BaseActivity
import com.cardes.eatournament.R
import com.cardes.eatournament.TeamManager
import com.cardes.eatournament.TeamScopeBaseActivity
import com.cardes.eatournament.db.entity.Team
import com.cardes.eatournament.di.TeamInjection
import com.cardes.eatournament.viewmodel.TeamPlayerListViewModel
import com.cardes.eatournament.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_team_player_list.*
import javax.inject.Inject

class TeamPlayerListActivity : TeamScopeBaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: TeamPlayerListViewModel

    private val playerAdapter: PlayerAdapter by lazy { PlayerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_player_list)

        TeamInjection.inject(this, teamManager)

        initViews()

        viewModel = ViewModelProviders.of(this, viewModelFactory)[TeamPlayerListViewModel::class.java]

    }

    private fun initViews() {
        playerList.adapter = playerAdapter
        playerList.layoutManager = LinearLayoutManager(this)
    }

    private fun bind() {
        viewModel.getPlayersFromTeam()
            .subscribe({
                playerAdapter.setPlayers(it)
            }, {
                Log.e("TeamPlayerListActivity", it.toString())
            })
            .let { disposables.add(it) }

        viewModel.getTeam()
            .subscribe({
                title = getString(R.string.team_player_list_title, it.name)
            }, {
                Log.e("TeamPlayerListActivity", it.toString())
            })
            .let { disposables.add(it) }

    }

    override fun onResume() {
        super.onResume()
        bind()
    }

    override fun onPause() {
        super.onPause()
        unbind()
    }

    private fun unbind() {
        disposables.dispose()
    }
}
