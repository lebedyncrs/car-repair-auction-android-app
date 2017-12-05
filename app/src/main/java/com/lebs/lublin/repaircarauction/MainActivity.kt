package com.lebs.lublin.repaircarauction

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView
import com.lebs.lublin.repaircarauction.db.DbHelper
import com.lebs.lublin.repaircarauction.models.User
import kotlinx.android.synthetic.main.activity_login.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        singUp.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        })

        logIn.setOnClickListener { view ->
            val login = username.text.toString()
            val pass = passwordLogIn.text.toString()
            if (login == "user@user.com" && pass == "1234") {
                val intent = Intent(this, ApplicationActivity::class.java)
                intent.putExtra("user", User("user","1234", "Warsaw","Kierowca"))
                startActivity(intent)
            } else {
                val snackBar = Snackbar.make(view, "Niepoprawny email albo hasło", Snackbar.LENGTH_LONG)
                val textView = snackBar.view.findViewById<TextView>(android.support.design.R.id.snackbar_text)
                snackBar.view.setBackgroundColor(resources.getColor(R.color.colorError))
                textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
                snackBar.show()
            }
        }
    }
}
