package com.devslopes.datafrost1997.gitterchat.Services

import android.graphics.Color
import com.devslopes.datafrost1997.gitterchat.Controller.App
import java.util.*

/**
 * Created by datafrost1997 on 15/10/17.
 */
object UserDataService {

    var id = ""
    var avatarColor = ""
    var avatarName = ""
    var email = ""
    var name = ""

    fun logout() {
        id = ""
        avatarName = ""
        avatarColor = ""
        name = ""
        email = ""
        App.prefs.authToken = ""
        App.prefs.userEmail = ""
        App.prefs.isLoggedIn = false

    }

    fun returnAvatarColor (components: String) : Int {
        val strippedColor = components
                .replace("[","")
                .replace("]","")
                .replace(",","")

        var r = 0
        var g = 0
        var b = 0

        val scanner = Scanner(strippedColor)

        if (scanner.hasNext()) {
            r = (scanner.nextDouble() * 255).toInt()
            g = (scanner.nextDouble() * 255).toInt()
            b = (scanner.nextDouble() * 255).toInt()

        }

        return Color.rgb(r,g,b)
    }
}