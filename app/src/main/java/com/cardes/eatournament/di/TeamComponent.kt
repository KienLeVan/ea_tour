package com.cardes.eatournament.di

import com.cardes.eatournament.TeamManager
import com.cardes.eatournament.db.entity.Team
import dagger.BindsInstance
import dagger.Subcomponent

@TeamScope
@Subcomponent(modules = [TeamBaseActivityBindingModule::class])
abstract class TeamComponent {

    abstract fun inject(teamManager: TeamManager)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun team(team: Team): Builder
        fun build(): TeamComponent

    }
}
