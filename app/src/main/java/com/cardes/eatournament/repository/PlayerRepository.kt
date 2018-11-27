package com.cardes.eatournament.repository

import com.cardes.eatournament.db.entity.Player
import com.cardes.eatournament.gateway.TournamentDatabaseGateway
import io.reactivex.Flowable
import javax.inject.Inject

interface PlayerRepository {
    fun getPlayersFromTeam(teamId: Long): Flowable<List<Player>>
}

class PlayerRepositoryImpl @Inject constructor(private val tournamentDatabaseGateway: TournamentDatabaseGateway) : PlayerRepository {

    override fun getPlayersFromTeam(teamId: Long): Flowable<List<Player>> {
        return tournamentDatabaseGateway.getPlayersFromTeam(teamId)
    }

}
