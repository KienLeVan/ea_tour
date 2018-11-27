package com.cardes.eatournament.di

import com.cardes.eatournament.view.TeamPlayerListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface TeamBaseActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [TeamPlayerListActivityModule::class])
    fun teamPlayerListActivity(): TeamPlayerListActivity
}
