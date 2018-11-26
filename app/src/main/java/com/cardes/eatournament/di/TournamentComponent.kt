package com.cardes.eatournament.di

import android.app.Application
import com.cardes.TournamentApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [AndroidInjectionModule::class,
    AppModule::class,
    ActivityBindingModule::class])
abstract class TournamentComponent {

    @Component.Builder
    interface Builder {

       @BindsInstance
       fun application(application: Application): Builder
       fun build(): TournamentComponent
    }

    abstract fun inject(tournamentApplication: TournamentApplication)
}
