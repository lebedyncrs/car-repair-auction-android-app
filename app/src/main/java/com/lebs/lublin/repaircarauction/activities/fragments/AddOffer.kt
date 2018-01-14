package com.lebs.lublin.repaircarauction.activities.fragments


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fasterxml.jackson.databind.ObjectMapper
import com.lebs.lublin.repaircarauction.R
import com.lebs.lublin.repaircarauction.activities.ApplicationActivity
import com.lebs.lublin.repaircarauction.activities.forms.AddOfferForm
import com.lebs.lublin.repaircarauction.models.Offer
import com.lebs.lublin.repaircarauction.models.User
import com.lebs.lublin.repaircarauction.rest.RestApiClient
import kotlinx.android.synthetic.main.fragment_add_offer.*
import kotlinx.android.synthetic.main.fragment_add_offer.view.*

class AddOffer() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_add_offer, container, false)

        view.addOfferButton.setOnClickListener {
            val form = AddOfferForm(activity as ApplicationActivity)
            if (form.validate()) {
                val client = RestApiClient()
                val user = arguments["userId"] as Int
                var need_tow_truck: String;
                if (form.addOfferTowTruck.isChecked()) {
                    need_tow_truck = "1"
                } else {
                    need_tow_truck = "0"
                }
                val params = client.http.newParams()
                        .add("name", form.addOfferName.text.toString())
                        .add("description", form.addOfferDescription.text.toString())
                        .add("need_tow_truck", need_tow_truck)
                        .add("location", form.addOfferCitySpinner.selectedItem.toString())
                        .add("car_model", addOfferCarSpinner.selectedItem.toString())
                        .add("days_term", form.addOfferDays.text.toString())
                        .add("money_budget", form.moneyBudget.text.toString())
                        .add("author_id", "${user}")
                val res = client.post("auction-ads", params)
                val bundle = Bundle()
                bundle.putSerializable("data", getOffer())
                val fragment = OfferListFragment()
                fragment.arguments = bundle
                (activity as ApplicationActivity).changeFragment(fragment, OfferListFragment.actionBarTitle)
            }
        }
        return view
    }

    companion object {
        val actionBarTitle = "Dodaj ogłoszenie"
    }


    fun getOffer(): Offer {
        return Offer(
                1,
                addOfferName.text.toString(),
                addOfferDescription.text.toString(),
                addOfferTowTruck.isChecked,
                addOfferCitySpinner.selectedItem.toString(),
                addOfferCarSpinner.selectedItem.toString(),
                Integer.parseInt(addOfferDays.text.toString()),
                Integer.parseInt(moneyBudget.text.toString()),
                "Janusz"
        )
    }
}
