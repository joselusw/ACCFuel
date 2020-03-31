package com.jsw.accfuel.Application

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())
    }
}