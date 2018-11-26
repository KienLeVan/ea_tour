package com.cardes.eatournament.gateway

import com.cardes.eatournament.db.dao.TeamDao
import com.cardes.eatournament.db.entity.Team
import io.reactivex.Flowable
import javax.inject.Inject

interface TournamentDatabaseGateway {
    fun getTeams(): Flowable<List<Team>>
}

class TournamentDatabaseGatewayImpl @Inject constructor(private val teamDao: TeamDao) : TournamentDatabaseGateway {

    override fun getTeams(): Flowable<List<Team>> {
        return teamDao.getTeams()
    }

}
