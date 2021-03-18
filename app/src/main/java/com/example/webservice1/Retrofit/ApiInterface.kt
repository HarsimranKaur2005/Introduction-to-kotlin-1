package com.example.webservice1.Retrofit

import com.example.webservice1.Model.Model
import com.example.webservice1.Model.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    // Define end point
    @GET("v2/posts.json")
    fun getPosts(): Call<ResponseModel>
}