package com.cardes.eatournament.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.cardes.eatournament.db.entity.Player
import io.reactivex.Flowable

@Dao
abstract class PlayerDao {

    @Insert
    abstract fun insertBatch(seeds: List<Player>)

    @Query("select * from player where team_id=:teamId")
    abstract fun getPlayersFromTeam(teamId: Long): Flowable<List<Player>>

}
