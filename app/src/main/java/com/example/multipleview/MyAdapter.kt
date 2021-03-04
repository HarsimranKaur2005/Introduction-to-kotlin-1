package com.example.multipleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException


class MyAdapter(val context: Context, val list: List<Int>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        const val TEXT_VIEW = 0
        const val IMAGE_VIEW =1
        const val IMAGE_TEXT_VIEW=2
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    return when(viewType){
    TEXT_VIEW -> textViewHolder(inflater.inflate(R.layout.text_type, parent,false))
    IMAGE_VIEW -> imageViewHolder(inflater.inflate(R.layout.image_type, parent, false))
    IMAGE_TEXT_VIEW -> imageTextViewHolder(inflater.inflate(R.layout.image_text_type, parent, false))
    else -> throw IllegalArgumentException("No Holder")
    }
    }

    override fun getItemViewType(position: Int): Int =list[position]

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(list[position]){
            TEXT_VIEW-> {
                val viewHolderText = holder as textViewHolder
                viewHolderText.textView.text=context.getString(R.string.A)
            }
            IMAGE_VIEW-> {
                val viewHolderImage = holder as imageViewHolder
                viewHolderImage.imageView.setBackgroundResource(R.drawable.offers)}
            IMAGE_TEXT_VIEW-> {
                val viewHolderImageText = holder as imageTextViewHolder
                viewHolderImageText.textView_imagetext.text=context.getString(R.string.B)
                viewHolderImageText.imageView_imagetext.setBackgroundResource(R.drawable.food)

            }
            else-> throw IllegalArgumentException("No Bind Holder")
        }

    }

    override fun getItemCount() = list.size

    inner class textViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.text_type)
    }

    inner class imageViewHolder(view: View): RecyclerView.ViewHolder(view){
    val imageView: ImageView = view.findViewById(R.id.image_type)

    }

    inner class imageTextViewHolder(view: View): RecyclerView.ViewHolder(view){
    val textView_imagetext: TextView = view.findViewById(R.id.imagetext_textView)
        val imageView_imagetext: ImageView  = view.findViewById(R.id.imagetext_imageView)
    }


}