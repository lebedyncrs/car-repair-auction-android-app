package com.lebs.lublin.repaircarauction.models

import java.io.Serializable

class Offer : Serializable {
    val id: Int
    val name: String
    val description: String
    val isTowTruckNeeded: Boolean
    val location: String
    val carModel: String


    constructor(id: Int, name: String, description: String, isTowTruckNeeded: Boolean, location: String, carModel: String) {
        this.id = id
        this.name = name
        this.description = description
        this.isTowTruckNeeded = isTowTruckNeeded
        this.location = location
        this.carModel = carModel
    }
}