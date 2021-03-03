package com.example.recyclerview

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.MyAdapter.*

class MyAdapter(val myArrayList:ArrayList<Model>) :RecyclerView.Adapter<MyAdapter.myViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        return  myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row,parent, false))
    }

    override fun getItemCount(): Int {

        return myArrayList.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        holder.addr.text = myArrayList[position].address
        holder.headl.text = myArrayList[position].headline
        holder.imageView.setImageResource(myArrayList[position].img)
        holder.ratings.numStars = myArrayList[position].ratingstar
        holder.review.text = myArrayList[position].reviews
        holder.date.text = myArrayList[position].date
        holder.amount.text = myArrayList[position].amt



    }

    class myViewHolder(rowitem : View):RecyclerView.ViewHolder(rowitem) {

        val addr = rowitem.findViewById<TextView>(R.id.address_tv)
        val headl = rowitem.findViewById<TextView>(R.id.headline_tv)
        val imageView = rowitem.findViewById<ImageView>(R.id.imageeiw)
        val ratings = rowitem.findViewById<RatingBar>(R.id.ratingBar)
        val review = rowitem.findViewById<TextView>(R.id.review_tv)
        val date = rowitem.findViewById<TextView>(R.id.date_tv)
        val amount = rowitem.findViewById<TextView>(R.id.amt_tv)
    }
}