package com.example.newsfeedapp.Model

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("title")
    val title:String,
    @SerializedName("url")
    val url:String,
    @SerializedName("image")
    val image:String,
    @SerializedName("description")
    val description:String
) {
}