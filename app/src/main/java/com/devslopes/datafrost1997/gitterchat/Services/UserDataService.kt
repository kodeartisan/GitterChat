package com.devslopes.datafrost1997.gitterchat.Services

import android.graphics.Color
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
        AuthService.authToken = ""
        AuthService.userEmail = ""
        AuthService.isLoggedIn = ""

    }

    fun returnAvatarColor (components: String) : Int {
        val strippedColor = components
                .replace("[","")
                .replace("]","")
                .replace(",","")

        val r = 0
        val g = 0
        val b = 0

        val scanner = Scanner(strippedColor)

        if (scanner.hasNext()) {
            r = (scanner.nextDouble() * 255).toInt()
            g = (scanner.nextDouble() * 255).toInt()
            b = (scanner.nextDouble() * 255).toInt()

        }

        return Color.rgb(r,g,b)
    }
}