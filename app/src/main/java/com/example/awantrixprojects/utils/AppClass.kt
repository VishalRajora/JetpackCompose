package com.example.awantrixprojects.utils

import android.app.Application
import timber.log.Timber
import timber.log.Timber.Forest.plant


class AppClass : Application() {

    override fun onCreate() {
        super.onCreate()
        // initialize timber in application class
        plant(Timber.DebugTree())
    }
}