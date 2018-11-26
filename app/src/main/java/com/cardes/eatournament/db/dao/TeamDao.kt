package com.cardes.eatournament.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.cardes.eatournament.db.entity.Team
import io.reactivex.Flowable

@Dao
abstract class TeamDao {
    @Insert(onConflict = REPLACE)
    abstract fun insert(team: Team)

    @Insert(onConflict = REPLACE)
    abstract fun insertBatch(teamList: List<Team>)

    @Query("select * from team")
    abstract fun getTeams(): Flowable<List<Team>>
}

