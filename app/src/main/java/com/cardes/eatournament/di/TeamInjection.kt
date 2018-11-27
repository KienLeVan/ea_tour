package com.cardes.eatournament.di

import android.app.Activity
import dagger.android.HasActivityInjector

class TeamInjection {

    companion object {
        fun inject(activity: Activity, hasActivityInjector: HasActivityInjector) {
            hasActivityInjector.activityInjector().inject(activity)
        }
    }

}
