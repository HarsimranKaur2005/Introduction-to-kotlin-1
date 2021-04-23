package com.example.newsfeedapp.Model

import com.example.newsfeedapp.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("news")
    fun getNews(
        @Query("access_key")key:String,
        @Query("languages") lang:String
    ):Call<ResponseModel>
}