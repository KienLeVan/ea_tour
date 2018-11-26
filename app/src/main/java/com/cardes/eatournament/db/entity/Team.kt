package com.cardes.eatournament.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "team")
data class Team(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String) {
    companion object {
        fun seeds(): List<Team> = listOf(
            Team(id = 1, name = "Xoan"),
            Team(id = 2, name = "Hot gingers"),
            Team(id = 3, name = "4-100k"),
            Team(id = 4, name = "GoodLuck"),
            Team(id = 5, name = "Banh mi kep thit"),
            Team(id = 6, name = "Phuc high on the beach")
        )
    }
}

