package com.cardes.eatournament.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import com.cardes.eatournament.db.entity.Player

@Dao
abstract class PlayerDao {

    @Insert
    abstract fun insertBatch(seeds: List<Player>)

}
