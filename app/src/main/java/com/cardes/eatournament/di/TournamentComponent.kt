package com.cardes.eatournament.di

import android.app.Application
import com.cardes.TournamentApplication
import com.cardes.eatournament.TeamManager
import com.cardes.eatournament.TeamScopeBaseActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    MainActivityModule::class,
    AppModule::class,
    ActivityBindingModule::class])
abstract class TournamentComponent {

    @Component.Builder
    interface Builder {

       @BindsInstance
       fun application(application: Application): Builder
       fun build(): TournamentComponent
    }

    abstract fun teamManager(): TeamManager

    abstract fun teamComponentBuilder(): TeamComponent.Builder

    abstract fun inject(tournamentApplication: TournamentApplication)

    abstract fun inject(teamScopeBaseActivity: TeamScopeBaseActivity)
}
