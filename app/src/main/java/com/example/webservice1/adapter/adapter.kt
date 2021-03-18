package com.example.webservice1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.webservice1.Model.Model
import com.example.webservice1.R
import kotlinx.android.synthetic.main.item.view.*

class adapter(var context: Context, private val list : List<Model>): RecyclerView.Adapter<adapter.ViewHolder>() {

    /**
     * Provide reference to the type of views :- custom viewholder
     */
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val image:ImageView= view.findViewById(R.id.imgview_img)
        val title:TextView = view.findViewById(R.id.tv_title)
        var body:TextView = view.findViewById(R.id.tv_body)
    }

    /**
     * create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        //create a new views, which defines the UI of the list item
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent, false))
    }

    override fun getItemCount(): Int {
       return  list.size
    }

    /**
     * Replace the content of a view(invoked by layout manager)
     * used to replace/update views at a specific position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = list[position].postName
        holder.body.text = list[position].postMessage

        val profileImage = list[position].postProfileImgURL
        Glide.with(context).load(profileImage).placeholder(R.drawable.ic_launcher_background)
            .into(holder.image)

    }

}
