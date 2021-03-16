package com.example.webservice1.Model

import com.google.gson.annotations.SerializedName

data class Model(
        @SerializedName("id")
        val postId:Int,
        @SerializedName("title")
        val postTitle:String,
        @SerializedName("body")
        val postBody:String
) {
}