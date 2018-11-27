package com.cardes.eatournament

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.cardes.eatournament.db.entity.Team
import com.cardes.eatournament.view.TeamAdapter
import com.cardes.eatournament.view.TeamPlayerListActivity
import com.cardes.eatournament.viewmodel.MainActivityViewModel
import com.cardes.eatournament.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), TeamAdapter.TeamClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var teamManager: TeamManager

    private lateinit var viewModel: MainActivityViewModel

    private val teamAdapter by lazy { TeamAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        initViews()
        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainActivityViewModel::class.java]
    }

    private fun initViews() {
        teamList.adapter = teamAdapter
        teamList.layoutManager = GridLayoutManager(this, 2)
        title = getString(R.string.ea_teams)
    }

    private fun bind() {
        viewModel.getTeams()
            .subscribe({
                teamAdapter.setData(it)
            }, {
                Log.e("MainActivity", it.toString())
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

    override fun onTeamClick(team: Team) {
        teamManager.createTeamSession(team)
        startActivity(Intent(this, TeamPlayerListActivity::class.java))
    }

}
