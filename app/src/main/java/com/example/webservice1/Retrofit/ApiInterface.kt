package com.example.webservice1.Retrofit

import com.example.webservice1.Model.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    //this will define end point
    @GET("posts")
    fun getPost( @Query("id")postId:Int):Call<List<Model>>
}