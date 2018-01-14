package com.lebs.lublin.repaircarauction.models

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable
import java.nio.charset.Charset

class User() : Parcelable {
    var id: Int = 0
    var email: String = ""
    var password: String = ""
    var location: String = ""
    var role: String = ""

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        email = parcel.readString()
        password = parcel.readString()
        location = parcel.readString()
        role = parcel.readString()
    }

    constructor(id: Int, email: String, password: String, location: String, role: String) : this() {
        this.id = id
        this.email = email
        this.password = password
        this.location = location
        this.role = role
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(email)
        parcel.writeString(password)
        parcel.writeString(location)
        parcel.writeString(role)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

    fun isDriver(): Boolean {
        return this.role.equals("driver")
    }
}
