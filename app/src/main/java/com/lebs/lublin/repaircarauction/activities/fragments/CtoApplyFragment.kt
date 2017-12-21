package com.lebs.lublin.repaircarauction.activities.fragments

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lebs.lublin.repaircarauction.R

class CtoApplyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_cto_offer_apply, container, false)

        return view
    }

    companion object {
        val actionBarTitle = "Weż udział"
    }
}
