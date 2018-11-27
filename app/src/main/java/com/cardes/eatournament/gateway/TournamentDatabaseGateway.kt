package com.cardes.eatournament.gateway

import com.cardes.eatournament.db.dao.PlayerDao
import com.cardes.eatournament.db.dao.TeamDao
import com.cardes.eatournament.db.entity.Player
import com.cardes.eatournament.db.entity.Team
import io.reactivex.Flowable
import javax.inject.Inject

interface TournamentDatabaseGateway {
    fun getTeams(): Flowable<List<Team>>
    fun getPlayersFromTeam(teamId: Long): Flowable<List<Player>>
}

class TournamentDatabaseGatewayImpl @Inject constructor(
    private val teamDao: TeamDao,
    private val playerDao: PlayerDao
) : TournamentDatabaseGateway {

    override fun getPlayersFromTeam(teamId: Long): Flowable<List<Player>> {
        return playerDao.getPlayersFromTeam(teamId)
    }

    override fun getTeams(): Flowable<List<Team>> {
        return teamDao.getTeams()
    }

}
