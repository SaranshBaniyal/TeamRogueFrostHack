package com.example.startup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val data: List<Mydata>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater :LayoutInflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val datelist = data.map { it.date }
        val entrylist = data.map {it.entry}
        val labellist = data.map {it.label}
        holder.txttitle.text= datelist[holder.bindingAdapterPosition]
        holder.txtdescription.text= entrylist[holder.bindingAdapterPosition]
        holder.txtlabel.text= labellist[holder.bindingAdapterPosition]
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txttitle:TextView = itemView.findViewById(R.id.txttitle)
        var txtdescription:TextView= itemView.findViewById(R.id.txtdescription)
        var txtlabel:TextView= itemView.findViewById(R.id.txtlabel)
    }

}
