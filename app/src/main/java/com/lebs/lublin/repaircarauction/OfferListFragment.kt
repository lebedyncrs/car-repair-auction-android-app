package com.lebs.lublin.repaircarauction

import android.os.Bundle
import android.app.Fragment
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.lebs.lublin.repaircarauction.models.Offer
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_add_offer.*
import kotlinx.android.synthetic.main.fragment_offer_list.*
import java.io.Serializable

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

        val adapter = Adapter(offers, activity)
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

    inner class Adapter(data: List<Offer>, inflater: Context) : BaseAdapter() {
        val list = data;
        val context = inflater;

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val view: View = View.inflate(context, R.layout.offer_list_listview, null)
            val row = RowHolder(view)

            row.title.text = list[p0].name
            row.daysTerm.text = list[p0].daysTerm.toString()
            row.moneyBudget.text = list[p0].moneyBudget.toString()

            view.tag = row

            return view
        }

        override fun getItem(p0: Int): Any = list[p0]
        override fun getItemId(p0: Int): Long = p0.toLong()
        override fun getCount(): Int = list.count();

        inner class RowHolder(view: View) {
            val logo = view.findViewById<ImageView>(R.id.offer_logo);
            val title = view.findViewById<TextView>(R.id.offer_title);
            val daysTerm = view.findViewById<TextView>(R.id.daysTerm);
            val moneyBudget = view.findViewById<TextView>(R.id.moneyBudget);
        }
    }

    companion object {
        val actionBarTitle = "Moje Ogłoszenia"
    }
}
