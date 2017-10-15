package com.devslopes.datafrost1997.gitterchat.Services

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.devslopes.datafrost1997.gitterchat.Utilities.URL_CREATE_USER
import com.devslopes.datafrost1997.gitterchat.Utilities.URL_LOGIN
import com.devslopes.datafrost1997.gitterchat.Utilities.URL_REGISTER
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by datafrost1997 on 13/10/17.
 */
object AuthService {

    var isLoggedIn = false
    var userEmail = ""
    var authToken = ""

    fun registerUser(context: Context, email: String, password: String, complete: (Boolean) -> Unit) {


        val jsonBody = JSONObject()
        jsonBody.put("email",email)
        jsonBody.put("password", password)
        val requestBody = jsonBody.toString()

        val registerRequest = object : StringRequest(Method.POST, URL_REGISTER, Response.Listener { response ->
            println(response)
            complete(true)
        }, Response.ErrorListener { error ->
            Log.d("Error", "Could not register User: $error")
            complete(false)
        }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }

            override fun getBody(): ByteArray {
                return requestBody.toByteArray()
            }
        }
        Volley.newRequestQueue(context).add(registerRequest)
    }

    fun loginUser(context: Context, email: String, password: String, complete: (Boolean) -> Unit) {
        val jsonBody = JSONObject()
        jsonBody.put("email",email)
        jsonBody.put("password", password)
        val requestBody = jsonBody.toString()
        val loginRequest = object : JsonObjectRequest(Method.POST, URL_LOGIN, null, Response.Listener { response ->
//            Point where the JSON Object is parsed.
//            println(response)

            try {
                userEmail = response.getString("user")
                authToken = response.getString("token")
                isLoggedIn = true
                complete(true)
            } catch (e: JSONException) {
                Log.d("JSON", "EXC:" + e.localizedMessage)
                complete(false)
            }

        }, Response.ErrorListener { error ->
//             Point where the Error is dealt with.
            Log.d("Error", "Could not register User: $error")
            complete(false)

        }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
        }
            override fun getBody(): ByteArray {
                return requestBody.toByteArray()
            }
        }
        Volley.newRequestQueue(context).add(loginRequest)
    }

    fun createUser(context: Context, name: String, email: String, avatarName: String, avatarColor: String, complete: (Boolean) -> Unit) {

        val jsonBody = JSONObject()
        jsonBody.put("name",name)
        jsonBody.put("email", email)
        jsonBody.put("avatarName", avatarName)
        jsonBody.put("avatarColor", avatarColor)
        val requestBody = jsonBody.toString()

        val createRequest = object : JsonObjectRequest(Method.POST, URL_CREATE_USER, null, Response.Listener { response ->

         try {
             UserDataService.name = response.getString("name")
             UserDataService.email = response.getString("email")
             UserDataService.avatarName = response.getString("avatarName")
             UserDataService.avatarColor = response.getString("avatarColor")
             UserDataService.id = response.getString("_id")
             complete(true)
         }   catch (e: JSONException) {
             Log.d("JSON", "EXC " + e.localizedMessage)
             complete(false)
         }
        }, Response.ErrorListener { error ->
            Log.d("Error", "Could not add User: $error")
            complete(false)

        }) {
            override fun getBodyContentType(): String {
                return "application/json; charset=utf-8"
            }
            override fun getBody(): ByteArray {
                return requestBody.toByteArray()
            }

            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String> ()
                headers.put("Authorization", "Bearer $authToken")
                return headers
            }

        }

    }
    Volley.newRequestQueue(context).add(createRequest)
}