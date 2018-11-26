package com.cardes.eatournament

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface SchedulerProvider {
    fun ioScheduler(): Scheduler
    fun uiScheduler(): Scheduler
}

class SchedulerProviderImpl @Inject constructor() : SchedulerProvider {
    override fun ioScheduler(): Scheduler {
        return Schedulers.io()
    }

    override fun uiScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

}
