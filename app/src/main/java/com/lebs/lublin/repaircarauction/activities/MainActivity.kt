package com.lebs.lublin.repaircarauction.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lebs.lublin.repaircarauction.R
import com.lebs.lublin.repaircarauction.heplers.SnackBarHelper
import com.lebs.lublin.repaircarauction.models.User
import kotlinx.android.synthetic.main.activity_login.*
import android.os.StrictMode
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.lebs.lublin.repaircarauction.rest.RestApiClient


class MainActivity : AppCompatActivity() {

    var loginResponse: JsonNode? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        singUp.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        })

        logIn.setOnClickListener { view ->
            if (validCredentials()) {
                goToApplicationActivity()
            } else {
                SnackBarHelper.showError("Niepoprawny email lub hasło", view, this)
            }
        }
    }

    private fun validCredentials(): Boolean {
        val client = RestApiClient()
        val params = client.http.newParams()
//                .add("email", usernameLogin.text.toString())
//                .add("password", passwordLogIn.text.toString())
                .add("email", "final@fin.com")
                .add("password", "qwerqwer")
        val res = client.post("auth/sign-in", params)
        val mapper = ObjectMapper()
        val tree = mapper.readTree(res?.bodyAsString)

        if (res?.status == 200) {
            loginResponse = tree
        }
        return res?.status == 200;
    }

    private fun goToApplicationActivity() {
        val intent = Intent(this, ApplicationActivity::class.java)
        intent.putExtra("user", User(
                loginResponse?.get("user")?.get("email").toString(),
                "1234", loginResponse?.get("user")?.get("location").toString(),
                loginResponse?.get("user")?.get("role").toString())
        )
        intent.putExtra("authToken", loginResponse?.get("token").toString())
        startActivity(intent)
    }

}
