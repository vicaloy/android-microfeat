package com.valoy.microfeat

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MicroFeatApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}