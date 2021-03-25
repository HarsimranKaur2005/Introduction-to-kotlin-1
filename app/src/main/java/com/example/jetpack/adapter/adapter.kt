package com.example.jetpack.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.R
import com.example.jetpack.database.EmpEntity

class adapter(val context: Context):RecyclerView.Adapter<adapter.viewHolder>() {

var list = ArrayList<EmpEntity>()

    fun setListData(data:ArrayList<EmpEntity>){
        this.list=data
    }
    private var mylistener: AdapterView.OnItemClickListener? = null

    class viewHolder(view:View):RecyclerView.ViewHolder(view) {

        var name = view.findViewById<TextView>(R.id.tv_name)
        var address = view.findViewById<TextView>(R.id.tv_address)
        var phone = view.findViewById<TextView>(R.id.tv_phone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
    return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false))
    }

    override fun getItemCount(): Int {
    return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {


        var listitem = list?.get(position)
        var empName = list!![position].name
        var empaddr = list!![position].address
        var empph = list!![position].phone
        var empID = list!![position].id


        holder.name.text = empName
        holder.address.text = empaddr
        holder.phone.text = empph
    }


    //used to start connection b/w 2 activities/fragments
    fun setListener(listener: AdapterView.OnItemClickListener) {
        mylistener = listener
    }
}