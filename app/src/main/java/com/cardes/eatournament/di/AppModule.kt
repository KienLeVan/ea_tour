package com.cardes.eatournament.di

import com.cardes.eatournament.SchedulerProvider
import com.cardes.eatournament.SchedulerProviderImpl
import com.cardes.eatournament.repository.TeamRepository
import com.cardes.eatournament.repository.TeamRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [DatabaseModule::class])
interface AppModule {
    @Binds
    fun schedulerProvider(schedulerProvider: SchedulerProviderImpl) : SchedulerProvider

    @Binds
    fun teamRepository(teamRepository: TeamRepositoryImpl) : TeamRepository
}
