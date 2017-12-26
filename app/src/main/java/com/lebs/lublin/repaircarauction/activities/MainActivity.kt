package com.lebs.lublin.repaircarauction.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lebs.lublin.repaircarauction.R
import com.lebs.lublin.repaircarauction.heplers.SnackBarHelper
import com.lebs.lublin.repaircarauction.models.User
import kotlinx.android.synthetic.main.activity_login.*
import com.turbomanage.httpclient.HttpResponse
import org.apache.http.params.HttpConnectionParams.setConnectionTimeout
import com.turbomanage.httpclient.ParameterMap
import com.turbomanage.httpclient.BasicHttpClient
import com.turbomanage.httpclient.AsyncCallback
import com.turbomanage.httpclient.android.AndroidHttpClient
import android.os.StrictMode
import com.lebs.lublin.repaircarauction.rest.RestApiClient


class MainActivity : AppCompatActivity() {

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
        val login = usernameLogin.text.toString()
        val pass = passwordLogIn.text.toString()

        return login == "user@user.com" && pass == "1234"
    }

    private fun goToApplicationActivity() {
        val intent = Intent(this, ApplicationActivity::class.java)
        intent.putExtra("user", User("user", "1234", "Warsaw", "Kierowca"))
        startActivity(intent)
    }

}
