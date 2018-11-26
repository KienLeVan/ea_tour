package com.cardes.eatournament.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey

@Entity(
    tableName = "player",
    foreignKeys = [ForeignKey(
        entity = Team::class,
        parentColumns = ["id"],
        childColumns = ["team_id"]
    )]
)
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    @ColumnInfo(name = "team_id") val teamId: Long
) {
    companion object {
        fun seeds(): List<Player> {
            return listOf(
                Player(id = 0, name = "Kien Le", teamId = 1),
                Player(id = 0, name = "Nguyen Nguyen", teamId = 1),
                Player(id = 0, name = "Phat Chiem", teamId = 1),
                Player(id = 0, name = "Thu Pham", teamId = 1),
                Player(id = 0, name = "Loc Le", teamId = 1),
                Player(id = 0, name = "Quang Huynh", teamId = 2),
                Player(id = 0, name = "Phuc Hoang", teamId = 2),
                Player(id = 0, name = "Huy Duc", teamId = 2),
                Player(id = 0, name = "Trang Dang", teamId = 2),
                Player(id = 0, name = "Chau Quach", teamId = 2),
                Player(id = 0, name = "Phong Nguyen", teamId = 3),
                Player(id = 0, name = "Hung Luong", teamId = 3),
                Player(id = 0, name = "Tai Nguyen", teamId = 3),
                Player(id = 0, name = "Tuan Nguyen", teamId = 3),
                Player(id = 0, name = "Loc Nguyen", teamId = 3),
                Player(id = 0, name = "Ha Le", teamId = 4),
                Player(id = 0, name = "Nhan Ho", teamId = 4),
                Player(id = 0, name = "Trinh Le", teamId = 4),
                Player(id = 0, name = "Vinh Vu", teamId = 4),
                Player(id = 0, name = "Hien Tran", teamId = 4),
                Player(id = 0, name = "Lien Dang", teamId = 5),
                Player(id = 0, name = "Bach Vu", teamId = 5),
                Player(id = 0, name = "Thien Lam", teamId = 5),
                Player(id = 0, name = "Duy Thanh", teamId = 5),
                Player(id = 0, name = "Cong Nguyen", teamId = 5),
                Player(id = 0, name = "Ngoc Nguyen", teamId = 6),
                Player(id = 0, name = "Anh Trinh", teamId = 6),
                Player(id = 0, name = "Thang Pham", teamId = 6),
                Player(id = 0, name = "Anh Quoc", teamId = 6),
                Player(id = 0, name = "Phuc Nguyen", teamId = 6)
            )
        }
    }
}

