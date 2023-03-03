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
        holder.txttitle.text= datelist[position]
        holder.txtdescription.text= entrylist[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txttitle= itemView.findViewById<TextView>(R.id.txttitle)
        var txtdescription= itemView.findViewById<TextView>(R.id.txtdescription)
    }

}
