package com.cardes.eatournament

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.cardes.eatournament.view.TeamAdapter
import com.cardes.eatournament.viewmodel.MainActivityViewModel
import com.cardes.eatournament.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: MainActivityViewModel

    private val teamAdapter by lazy { TeamAdapter() }

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

    }
}
