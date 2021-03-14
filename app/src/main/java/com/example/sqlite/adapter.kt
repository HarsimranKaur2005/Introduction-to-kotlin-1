package com.example.sqlite

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.Executors

class adapter(var context: Context, var list: ArrayList<EmpEntity>):RecyclerView.Adapter<adapter.viewHolder>() {

    private var mylistener: OnItemClickListener? = null

    private val database = DatabaseBuilder.getInstance(context)
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
        var empID = list!![position].id


        holder.name.text = empName
        holder.address.text = empaddr
        holder.phone.text = empph


        // on clicking delete button
        holder.delete.setOnClickListener() {
            //calling implementation on fun onItemClickDelete() from mainActivity
            mylistener?.onItemClickDelete(position, empID)
            //  notify adapter that something is removed
            list.removeAt(position)
            notifyDataSetChanged()

        }


        //on clicking update button
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

                Log.i("Data", "=== Name: $nameupdated, Contact: $phoneUpdated, Address: $addrUpdated ===")

               mylistener?.onItemClickUpdate(position, nameupdated, addrUpdated, phoneUpdated, empID)


                holder.editItemRow.visibility=View.GONE
                holder.itemrow.visibility = View.VISIBLE
                Toast.makeText(context,"Data updated sucessfully!!",Toast.LENGTH_SHORT).show()

               list[position]=EmpEntity(empID, nameupdated, addrUpdated, phoneUpdated)
                notifyDataSetChanged()


            }
        }
    }





    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //all views of item xml
        var name = view.findViewById<TextView>(R.id.tv_name)
        var address = view.findViewById<TextView>(R.id.address)
        var delete = view.findViewById<Button>(R.id.btn_delete)
        var update = view.findViewById<Button>(R.id.btn_edit)
        var phone = view.findViewById<TextView>(R.id.phone)

        //all views that ae used to edit feilds
        var editname=view.findViewById<EditText>(R.id.empNameEditTextView)
        var editaddress =view.findViewById<EditText>(R.id.empAddressEditTextView)
        var editPhone = view.findViewById<EditText>(R.id.empContactEditTextView)
        var updateButton = view.findViewById<Button>(R.id.updateDetailsBtn)

        // views of layouts
        var itemrow = view.findViewById<ConstraintLayout>(R.id.itemRow)
        var editItemRow = view.findViewById<ConstraintLayout>(R.id.editItemRow)
    }

    //used to start connection b/w 2 activities/fragments
    fun setListener(listener: OnItemClickListener) {
        mylistener = listener
    }

    interface OnItemClickListener {
        fun onItemClickDelete(position: Int, empID:Int
        )
        fun onItemClickUpdate(position: Int, name:String, address:String, phone:String, id:Int)
    }
}