package com.devslopes.datafrost1997.gitterchat.Controller

import android.app.Application
import com.devslopes.datafrost1997.gitterchat.Utilities.SharedPrefs

/**
 * Created by datafrost1997 on 28/10/17.
 */
class App: Application(){

    companion object {
        lateinit var prefs: SharedPrefs
    }
    override fun onCreate() {
        prefs = SharedPrefs(applicationContext)
        super.onCreate()
    }
}