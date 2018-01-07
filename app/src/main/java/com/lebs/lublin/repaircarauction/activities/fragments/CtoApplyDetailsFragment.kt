package com.lebs.lublin.repaircarauction.activities.fragments

import android.Manifest
import android.os.Bundle
import android.app.Fragment
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.lebs.lublin.repaircarauction.R
import com.lebs.lublin.repaircarauction.activities.ApplicationActivity

class CtoApplyDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_cto_offer_apply_details, container, false)
        val button = view.findViewById<Button>(R.id.ctoOfferApplyDetButton)
        button.setOnClickListener({
            // Here, thisActivity is the current activity
            if (ContextCompat.checkSelfPermission(activity,
                    Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                        Manifest.permission.CALL_PHONE)) {

                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.

                } else {
                    ActivityCompat.requestPermissions(
                            activity,
                            arrayOf(Manifest.permission.CALL_PHONE),
                            2
                    );
                }
            } else {
               makeCall("123412341")
            }
        })

        return view
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            2 -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    makeCall("123456789")
                } else {
                    println("permission denied, boo")
                }
                return
            }
        }// other 'case' lines to check for other
        // permissions this app might request
    }

    fun makeCall(phoneNumber: String) {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:${phoneNumber}")
        startActivity(callIntent)
    }

    companion object {
        val actionBarTitle = "Weż udział"
    }
}
