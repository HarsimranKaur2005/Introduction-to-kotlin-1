package com.example.newsfeedapp

import com.example.newsfeedapp.Model.News
import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("data")
    val data: ArrayList<News>
) {
}