package com.devslopes.datafrost1997.gitterchat.Controller

import android.app.Application
import com.devslopes.datafrost1997.gitterchat.Utilities.SharedPrefs

/**
 * Created by datafrost1997 on 28/10/17.
 */
class App: Application(){

    companion object {
        lateinit var sharedPreferences: SharedPrefs
    }
    override fun onCreate() {
        sharedPreferences = SharedPrefs(applicationContext)
        super.onCreate()
    }
}