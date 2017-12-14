package com.lebs.lublin.repaircarauction.activities

import android.os.Bundle
import android.app.Fragment
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.lebs.lublin.repaircarauction.R
import com.lebs.lublin.repaircarauction.activities.adapters.OfferListFragmentListViewAdapter
import com.lebs.lublin.repaircarauction.models.Offer

class OfferListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_offer_list, container, false)
        val listView: ListView = view.findViewById<ListView>(R.id.offer_list_view)

        var offers = listOf<Offer>(
                Offer(1, "Zmienić opony na zimowe", "Zmienić opony na zimowe", true, "Warsaw", "Audi A6",1,250),
                Offer(2, "Wymiana Masła", "Wymiana Masła", true, "Warsaw", "BMW X5",1, 45),
                Offer(3, "Zainstalować LPG", "Zainstalować LPG", true, "Warsaw", "Ford Mustang",3, 2500)
        )

        if(arguments != null) {
            offers = offers.plus(arguments.getSerializable("data") as Offer)
        }

        val adapter = OfferListFragmentListViewAdapter(offers, activity)
        listView.adapter = adapter

        listView.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                println("OnItemClickListener");
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
        val actionBarTitle = "Moje Ogłoszenia"
    }
}
