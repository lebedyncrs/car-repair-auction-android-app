package com.lebs.lublin.repaircarauction.activities.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.lebs.lublin.repaircarauction.R
import com.lebs.lublin.repaircarauction.models.Offer

class CtoOfferListFragmentListViewAdapter(data: List<Offer>, inflater: Context) : BaseAdapter() {
    val list = data;
    val context = inflater;

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.cto_offer_list_listview, null)
        val row = RowHolder(view)

        row.title.text = list[p0].carModel
        row.author.text = list[p0].author
        row.daysTerm.text = list[p0].daysTerm.toString()

        view.tag = row

        return view
    }

    override fun getItem(p0: Int): Any = list[p0]
    override fun getItemId(p0: Int): Long = p0.toLong()
    override fun getCount(): Int = list.count();

    inner class RowHolder(view: View) {
        val logo = view.findViewById<ImageView>(R.id.ctoOfferLogo);
        val title = view.findViewById<TextView>(R.id.ctoOfferTitle);
        val daysTerm = view.findViewById<TextView>(R.id.ctoDaysTerm);
        val author = view.findViewById<TextView>(R.id.ctoAuthorName);
    }
}