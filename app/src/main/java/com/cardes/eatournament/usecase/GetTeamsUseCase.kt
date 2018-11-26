package com.cardes.eatournament.usecase

import com.cardes.eatournament.db.entity.Team
import com.cardes.eatournament.repository.TeamRepository
import io.reactivex.Flowable
import javax.inject.Inject

interface GetTeamsUseCase {
    fun execute(): Flowable<List<Team>>
}

class GetTeamsUseCaseImpl @Inject constructor(private val teamRepository: TeamRepository): GetTeamsUseCase {
    override fun execute(): Flowable<List<Team>> {
        return teamRepository.getTeams()
    }

}
