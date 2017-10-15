package com.devslopes.datafrost1997.gitterchat.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devslopes.datafrost1997.gitterchat.R
import com.devslopes.datafrost1997.gitterchat.Services.AuthService
import kotlinx.android.synthetic.main.activity_create_user.*
import kotlinx.android.synthetic.main.activity_login.*

class loginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginSpinner.visibility = View.INVISIBLE
    }

    fun loginLoginBtnClicked(view: View) {

        enableSpinner(true)

        val email = loginEmailTxt.text.toString()
        val password = loginPasswordText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()){
            AuthService.loginUser(this, email, password) { loginSucess ->
                if (loginSucess) {
                    AuthService.findUserByEmail(this) { findSucess ->
                        if (findSucess) {
                            enableSpinner(false)
                            finish()
                        } else {
                            errorToast()
                        }
                    }
                } else {
                    errorToast()
                }
            }
        } else {
            Toast.makeText(this,"Please Fill Both Fields", Toast.LENGTH_LONG).show()
        }

    }

    fun loginCreateUserBtnClicked(view: View) {
        val createUserIntent = Intent(this, CreateUserActivity::class.java)
        startActivity(createUserIntent)
        finish()
    }

    fun errorToast() {
        Toast.makeText(this, "Something went Wrong, Please Try Again",
                Toast.LENGTH_LONG).show()
        enableSpinner(false)
    }

    fun enableSpinner(enable: Boolean) {
        if (enable) {
            loginSpinner.visibility = View.VISIBLE
        } else {
            loginSpinner.visibility = View.INVISIBLE
        }
        loginLoginBtn.isEnabled = !enable
        loginCreatUserBtn.isEnabled = !enable
    }
}
