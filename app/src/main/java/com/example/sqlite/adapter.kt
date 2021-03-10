package com.example.sqlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class adapter(var list: List<EmpEntity>):RecyclerView.Adapter<adapter.viewHolder>() {
    //lateinit var list:List<EmpEntity>
    private var mylistener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        val size = list.size

        return size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        var listitem = list?.get(position)
        var empName = list!![position].name
        var empaddr = list!![position].address
        var empph = list!![position].phone


        holder.name.text = empName
        holder.address.text = empaddr
        holder.phone.text = empph


        holder.delete.setOnClickListener() {


            mylistener?.onItemClickDelete(position)
            //  notifyDataSetChanged()
            notifyItemRemoved(position)

        }


        holder.update.setOnClickListener() {

            //add data to edit text
            holder.editname.setText(empName)
            holder.editaddress.setText(empaddr)
            holder.editPhone.setText(empph)

            //hide view
            holder.itemrow.visibility = View.INVISIBLE

            //show view for edit details
            holder.editItemRow.visibility = View.VISIBLE

            holder.updateButton.setOnClickListener() {

                val nameupdated = holder.editname.text.toString()
                val addrUpdated = holder.editaddress.text.toString()
                val phoneUpdated = holder.editPhone.text.toString()

                mylistener?.onItemClickUpdate(position, nameupdated, addrUpdated, phoneUpdated)
               notifyItemChanged(position)
            }
        }
    }





    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var name = view.findViewById<TextView>(R.id.tv_name)
        var address = view.findViewById<TextView>(R.id.address)
        var delete = view.findViewById<Button>(R.id.btn_delete)
        var update = view.findViewById<Button>(R.id.btn_edit)
        var phone = view.findViewById<TextView>(R.id.phone)

        var editname=view.findViewById<EditText>(R.id.empNameEditTextView)
        var editaddress =view.findViewById<EditText>(R.id.empAddressEditTextView)
        var editPhone = view.findViewById<EditText>(R.id.empContactEditTextView)
        var updateButton = view.findViewById<Button>(R.id.updateDetailsBtn)

        var itemrow = view.findViewById<ConstraintLayout>(R.id.itemRow)
        var editItemRow = view.findViewById<ConstraintLayout>(R.id.editItemRow)
    }


    fun setListener(listener: OnItemClickListener) {
        mylistener = listener
    }

    interface OnItemClickListener {
        fun onItemClickDelete(position: Int
        )
        fun onItemClickUpdate(position: Int, name:String, address:String, phone:String)
    }
}