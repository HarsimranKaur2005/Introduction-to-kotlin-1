package com.example.webservice1.Model

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("posts")
    val posts: ArrayList<Model>
)