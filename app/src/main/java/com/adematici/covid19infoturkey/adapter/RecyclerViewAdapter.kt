package com.adematici.covid19infoturkey.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adematici.covid19infoturkey.R
import com.adematici.covid19infoturkey.model.CoronaModel
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerViewAdapter(private val coronaList: ArrayList<CoronaModel>)
    : RecyclerView.Adapter<RecyclerViewAdapter.CoronaHolder>() {

    class CoronaHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }

    override fun getItemCount(): Int {
        return coronaList.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoronaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return CoronaHolder(view)
    }

    override fun onBindViewHolder(holder: CoronaHolder, position: Int) {
        holder.itemView.textViewDetailTarih.text = coronaList[position].tarih
        holder.itemView.textViewDetailGunlukTest.text = coronaList[position].gunluk_test
        holder.itemView.textViewDetailGunlukVaka.text = coronaList[position].gunluk_vaka
        holder.itemView.textViewDetailGunlukVefat.text = coronaList[position].gunluk_vefat
        holder.itemView.textViewDetailGunlukIyilesen.text = coronaList[position].gunluk_iyilesen
        holder.itemView.textViewDetailAgirHastaSayisi.text = coronaList[position].agir_hasta_sayisi
    }
}