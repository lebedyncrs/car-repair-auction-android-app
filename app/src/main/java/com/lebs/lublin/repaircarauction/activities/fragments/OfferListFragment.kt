package com.lebs.lublin.repaircarauction.activities.fragments

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.lebs.lublin.repaircarauction.R
import com.lebs.lublin.repaircarauction.activities.adapters.OfferListFragmentListViewAdapter
import com.lebs.lublin.repaircarauction.models.Offer
import com.lebs.lublin.repaircarauction.rest.RestApiClient

class OfferListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_offer_list, container, false)
        val listView: ListView = view.findViewById<ListView>(R.id.offer_list_view)

        val client = RestApiClient()
        val userId = arguments.getInt("userId") as Int
        val res = client.get("auction-ads/${userId}", null)
        val mapper = ObjectMapper()
        val tree = mapper.readTree(res?.bodyAsString)

        var offers = arrayListOf<Offer>()
        for (item in tree) {
            offers.add(Offer(
                    item["id"].asInt(),
                    item["name"].asText(),
                    item["description"].asText(),
                    item["need_tow_truck"].asBoolean(),
                    item["location"].asText(),
                    item["car_model"].asText(),
                    item["days_term"].asInt(),
                    item["money_budget"].asInt(),
                    "Piotr"
            ))
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
