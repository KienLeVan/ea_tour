package com.cardes.eatournament.di

import android.app.Application
import com.cardes.eatournament.db.TournamentDatabase
import com.cardes.eatournament.db.dao.TeamDao
import com.cardes.eatournament.gateway.TournamentDatabaseGateway
import com.cardes.eatournament.gateway.TournamentDatabaseGatewayImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DatabaseModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun tournamentDatabase(application: Application) : TournamentDatabase = TournamentDatabase.getTournamentDatabase(application)

        @JvmStatic
        @Provides
        fun teamDao(tournamentDatabase: TournamentDatabase) : TeamDao = tournamentDatabase.teamDao()
    }

    @Binds
    abstract fun tournamentDatabaseGateway(tournamentDatabaseGateway: TournamentDatabaseGatewayImpl) : TournamentDatabaseGateway

}
