package com.cardes.eatournament.repository

import com.cardes.eatournament.db.entity.Team
import com.cardes.eatournament.gateway.TournamentDatabaseGateway
import io.reactivex.Flowable
import javax.inject.Inject

interface TeamRepository {
   fun getTeams(): Flowable<List<Team>>
}

class TeamRepositoryImpl @Inject constructor(private val tournamentDatabaseGateway: TournamentDatabaseGateway) : TeamRepository {

   override fun getTeams(): Flowable<List<Team>> {
      return tournamentDatabaseGateway.getTeams()
   }

}
