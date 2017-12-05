package com.lebs.lublin.repaircarauction

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lebs.lublin.repaircarauction.db.DbHelper
import com.lebs.lublin.repaircarauction.models.User
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        singUpButton.setOnClickListener { view ->
            val user = User(
                    email.text.toString(),
                    passwordSingUp.text.toString(),
                    leavingIn.text.toString(),
                    roleSpinner.selectedItem.toString()
            )

            val inf = Intent(this, ApplicationActivity::class.java)
            inf.putExtra("user", user)
            startActivity(inf)
        }
    }
}
