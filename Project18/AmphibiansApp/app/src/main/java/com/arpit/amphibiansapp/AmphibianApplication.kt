package com.arpit.amphibiansapp

import android.app.Application
import com.arpit.amphibiansapp.data.AppContainer
import com.arpit.amphibiansapp.data.DefaultAppContainer

class AmphibianApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}