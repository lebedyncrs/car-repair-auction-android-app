package com.lebs.lublin.repaircarauction.activities.forms

import com.lebs.lublin.repaircarauction.R
import com.lebs.lublin.repaircarauction.activities.RegisterActivity
import com.lebs.lublin.repaircarauction.heplers.SnackBarHelper
import kotlinx.android.synthetic.main.activity_register.*

class RegistrationForm(activity: RegisterActivity) {
    val activity: RegisterActivity = activity
    val passwordSingUp = activity.passwordSingUp
    val email = activity.email
    val leavingIn = activity.leavingIn


    fun validate(): Boolean {
        var success = true
        var message = "";
        if (passwordSingUp.text.toString().isEmpty()) {
            message += "Hasło puste \n"
            success = false
        }

        if (email.text.toString().isEmpty()) {
            message += "Email pusty. "
            success = false
        }

        if (leavingIn.text.toString().isEmpty()) {
            message += "Leaving In pusty"
            success = false
        }

        if (!success) {
            SnackBarHelper.showError(message, activity.findViewById(R.id.registerView), activity)
        }

        return success
    }
}