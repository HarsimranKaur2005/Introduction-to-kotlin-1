package com.example.webservice1.Model

import com.google.gson.annotations.SerializedName

data class Model(
        @SerializedName("name")
        val postName: String,
        @SerializedName("message")
        val postMessage: String,
        @SerializedName("profileImage")
        val postProfileImgURL: String
)