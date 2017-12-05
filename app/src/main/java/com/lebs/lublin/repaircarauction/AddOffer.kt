package com.lebs.lublin.repaircarauction


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lebs.lublin.repaircarauction.models.Offer
import kotlinx.android.synthetic.main.fragment_add_offer.*
import kotlinx.android.synthetic.main.fragment_add_offer.view.*

class AddOffer : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_add_offer, container, false)

        view.addOfferButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("data", getOffer())
            val fragment = OfferListFragment()
            fragment.arguments = bundle
            (activity as ApplicationActivity).changeFragment(fragment, OfferListFragment.actionBarTitle)
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
                Integer.parseInt(moneyBudget.text.toString())
        )
    }
}
