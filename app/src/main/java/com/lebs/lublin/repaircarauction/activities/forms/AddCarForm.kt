package com.lebs.lublin.repaircarauction.activities.forms

import com.lebs.lublin.repaircarauction.activities.ApplicationActivity
import kotlinx.android.synthetic.main.fragment_add_car.*

class AddCarForm(activity: ApplicationActivity) {
    val activity: ApplicationActivity = activity
    val carModel = activity.addCarModel
    val year = activity.addCarYear
    val distance = activity.addCarDistance
    val power = activity.addCarPower
    val fuelType = activity.addCarFuelType
    val bodyType = activity.addCarBodyType
    val dors = activity.addCarDoors
    val color = activity.addCarColor
}