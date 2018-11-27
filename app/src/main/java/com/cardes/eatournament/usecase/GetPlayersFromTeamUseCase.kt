package com.cardes.eatournament.usecase

import com.cardes.eatournament.db.entity.Player
import com.cardes.eatournament.db.entity.Team
import com.cardes.eatournament.repository.PlayerRepository
import io.reactivex.Flowable
import javax.inject.Inject

interface GetPlayersFromTeamUseCase {
    fun execute(): Flowable<List<Player>>
}

class GetPlayersFromTeamUseCaseImpl @Inject constructor(
    private val playerRepository: PlayerRepository,
    private val team: Team
) :
    GetPlayersFromTeamUseCase {

    override fun execute(): Flowable<List<Player>> {
        return playerRepository.getPlayersFromTeam(team.id)
    }

}
