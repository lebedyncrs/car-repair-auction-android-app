package com.lebs.lublin.repaircarauction.activities.fragments

import android.os.Bundle
import android.app.Fragment
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
            (activity as ApplicationActivity).changeFragment(CtoApplyFragment(), CtoApplyFragment.actionBarTitle)
        })

        return view
    }

    companion object {
        val actionBarTitle = "Weż udział"
    }
}
