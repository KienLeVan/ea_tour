package com.cardes.eatournament.db

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration
import com.cardes.eatournament.db.dao.PlayerDao
import com.cardes.eatournament.db.dao.TeamDao
import com.cardes.eatournament.db.entity.Player
import com.cardes.eatournament.db.entity.Team
import com.cardes.eatournament.ioThread

@Database(entities = [Team::class, Player::class], version = 2, exportSchema = true)
abstract class TournamentDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "ea_tournament.db"
        private var INSTANCE: TournamentDatabase? = null

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "CREATE TABLE IF NOT EXISTS `player` " +
                            "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                            " `name` TEXT NOT NULL," +
                            " `team_id` INTEGER NOT NULL," +
                            " FOREIGN KEY(`team_id`) REFERENCES `team`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )"
                )
            }

        }

        fun getTournamentDatabase(application: Application): TournamentDatabase {
            if (INSTANCE == null) {
                synchronized(TournamentDatabase::class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            application.applicationContext,
                            TournamentDatabase::class.java,
                            DATABASE_NAME
                        )
                            .addMigrations(MIGRATION_1_2)
                            .addCallback(object : RoomDatabase.Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    ioThread {
                                        INSTANCE?.apply {
                                            teamDao().insertBatch(Team.seeds())
                                            playerDao().insertBatch(Player.seeds())
                                        }
                                    }
                                }
                            })
                            .build()
                    }
                }
            }

            return INSTANCE!!
        }
    }

    abstract fun teamDao(): TeamDao
    abstract fun playerDao(): PlayerDao

}
