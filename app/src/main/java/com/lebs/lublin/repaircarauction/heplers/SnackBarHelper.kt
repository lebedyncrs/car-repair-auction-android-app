package com.lebs.lublin.repaircarauction.heplers

import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.lebs.lublin.repaircarauction.R

class SnackBarHelper {
    companion object {
        fun showError(message: String, view: View, activity: AppCompatActivity) {
            val snackBar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            val textView = snackBar.view.findViewById<TextView>(android.support.design.R.id.snackbar_text)
            snackBar.view.setBackgroundColor(activity.resources.getColor(R.color.colorError))
            textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
            snackBar.show()
        }
    }
}