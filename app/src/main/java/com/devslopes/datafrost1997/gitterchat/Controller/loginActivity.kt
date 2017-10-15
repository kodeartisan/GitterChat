package com.devslopes.datafrost1997.gitterchat.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.devslopes.datafrost1997.gitterchat.R
import com.devslopes.datafrost1997.gitterchat.Services.AuthService
import kotlinx.android.synthetic.main.activity_login.*

class loginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginLoginBtnClicked(view: View) {

        val email = loginEmailTxt.text.toString()
        val password = loginPasswordText.text.toString()

        AuthService.loginUser(this, email, password) { loginSucess ->
            AuthService.findUserByEmail(this) { findSucess ->
                if (findSucess) {
                    finish()
                }
            }
        }
    }

    fun loginCreateUserBtnClicked(view: View) {
        val createUserIntent = Intent(this, CreateUserActivity::class.java)
        startActivity(createUserIntent)
        finish()
    }
}
