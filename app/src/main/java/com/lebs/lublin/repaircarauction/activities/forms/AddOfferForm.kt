package com.lebs.lublin.repaircarauction.activities.forms

import com.lebs.lublin.repaircarauction.R
import com.lebs.lublin.repaircarauction.activities.ApplicationActivity
import com.lebs.lublin.repaircarauction.heplers.SnackBarHelper
import kotlinx.android.synthetic.main.fragment_add_offer.*

class AddOfferForm(activity: ApplicationActivity) {
    val activity: ApplicationActivity = activity
    val addOfferName = activity.addOfferName
    val addOfferCarSpinner = activity.addOfferCarSpinner
    val addOfferTowTruck = activity.addOfferTowTruck
    val addOfferDescription = activity.addOfferDescription
    val addOfferCitySpinner = activity.addOfferCitySpinner
    val addOfferDays = activity.addOfferDays
    val moneyBudget = activity.moneyBudget


    fun validate(): Boolean {
        var success = true
        var message = "";
        if (addOfferName.text.toString().isEmpty()) {
            message += "addOfferName puste \n"
            success = false
        }

        if (addOfferCarSpinner.selectedItem.toString().isEmpty()) {
            message += "addOfferCarSpinner pusty. "
            success = false
        }

        if (addOfferDescription.text.toString().isEmpty()) {
            message += "addOfferDescription pusty"
            success = false
        }

        if (addOfferCitySpinner.selectedItem.toString().isEmpty()) {
            message += "addOfferCitySpinner pusty"
            success = false
        }

        if (addOfferDays.text.toString().isEmpty()) {
            message += "addOfferDays pusty"
            success = false
        }

        if (moneyBudget.text.toString().isEmpty()) {
            message += "moneyBudget pusty"
            success = false
        }

        if (!success) {
            SnackBarHelper.showError(message, activity.findViewById(R.id.add_offer), activity)
        }

        return success
    }
}
