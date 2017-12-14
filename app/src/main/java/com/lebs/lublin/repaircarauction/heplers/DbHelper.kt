package com.lebs.lublin.repaircarauction.heplers

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.lebs.lublin.repaircarauction.models.User

class DbHelper : SQLiteOpenHelper {
    constructor(context: Context?) : super(context, "car_repair", null, 1)

    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
        sqLiteDatabase?.execSQL("CREATE TABLE users (\n" +
                "    id int,\n" +
                "    email varchar(255),\n" +
                "    password varchar(255),\n" +
                "    role varchar(255),\n" +
                "    location varchar(255)\n" +
                ");")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP IF EXIST users")
    }

    fun insertUser(user: User) {
        val db = writableDatabase
        val values = ContentValues()
        values.put("email", user.email)
        values.put("password", user.password)

        db.insert("users", null, values)
    }

    fun selectUsers():Cursor {
        val db = readableDatabase

        return db.rawQuery("SELECT * FROM users", arrayOf())
    }
}