package com.example.newsfeedapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsfeedapp.Model.News

class Adapter(var context: Context, private val list:List<News>):RecyclerView.Adapter<Adapter.ViewHolder>() {

    /**
     * Provide reference to the type of views:- custom viewholder
     */
    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val image:ImageView = view.findViewById(R.id.img)
        val title: TextView = view.findViewById(R.id.title_TV)
        var desc: TextView = view.findViewById(R.id.desciption_TV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //create a new views, which defines the UI of the list item
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
       return list.size
    }

    /**
     * Replace the content of a view(invoked by layout manager)
     * used to replace/upfate views at a specific position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = list[position].title
        holder.desc.text = list[position].description

        val img = list[position].image
        Glide.with(context).load(img
        ).placeholder(R.drawable.ic_launcher).into(holder.image)
    }
}