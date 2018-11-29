package com.cardes.eatournament.usecase

import com.cardes.eatournament.db.entity.Team
import io.reactivex.Single
import javax.inject.Inject

interface GetTeamUseCase {
    fun execute(): Single<Team>
}

class GetTeamUseCaseImpl @Inject constructor(private val team: Team) : GetTeamUseCase {

    override fun execute(): Single<Team> {
        return Single.just(team)
    }

}
