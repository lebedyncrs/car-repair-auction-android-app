package com.lebs.lublin.repaircarauction.activities.fragments

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.lebs.lublin.repaircarauction.R
import com.lebs.lublin.repaircarauction.activities.ApplicationActivity
import com.lebs.lublin.repaircarauction.activities.adapters.CtoOfferListFragmentListViewAdapter
import com.lebs.lublin.repaircarauction.models.Offer

class CtoOfferListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_offer_list, container, false)
        val listView: ListView = view.findViewById<ListView>(R.id.offer_list_view)

        var offers = listOf<Offer>(
                Offer(1, "Zmienić opony na zimowe", "Zmienić opony na zimowe", true, "Warsaw", "Audi A6",1,250, "Piotr")
        )

        if(arguments != null) {
            offers = offers.plus(arguments.getSerializable("data") as Offer)
        }

        val adapter = CtoOfferListFragmentListViewAdapter(offers, activity)
        listView.adapter = adapter

        listView.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (activity as ApplicationActivity).changeFragment(CtoApplyDetailsFragment(), CtoApplyDetailsFragment.actionBarTitle)
            }
        })

        listView.setOnItemLongClickListener(object : AdapterView.OnItemLongClickListener {
            override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long): Boolean {
                println("OnItemLongClickListener");
                return true
            }
        })

        return view
    }

    companion object {
        val actionBarTitle = "Aukcje"
    }
}
