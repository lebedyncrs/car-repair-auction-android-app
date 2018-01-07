package com.lebs.lublin.repaircarauction.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lebs.lublin.repaircarauction.R
import com.lebs.lublin.repaircarauction.activities.forms.RegistrationForm
import com.lebs.lublin.repaircarauction.models.User
import com.lebs.lublin.repaircarauction.rest.RestApiClient
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var form = RegistrationForm(this)
        singUpButton.setOnClickListener {
            val user = User(
                    email.text.toString(),
                    passwordSingUp.text.toString(),
                    leavingIn.text.toString(),
                    resources.getStringArray(R.array.roleListKeys)[roleSpinner.selectedItemPosition]
            )
            if (form.validate()) {
                val client = RestApiClient()
                val params = client.http.newParams()
                        .add("email", user.email)
                        .add("password", user.password)
                        .add("role", user.role)
                        .add("location", user.location)
                val res = client.post("auth/sign-up", params)
                val inf = Intent(this, ApplicationActivity::class.java)
                inf.putExtra("user", user)
                startActivity(inf)
            }
        }
    }
}
