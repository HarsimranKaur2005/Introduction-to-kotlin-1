package com.example.webservice1

import android.app.ProgressDialog
import android.graphics.ColorSpace
import android.graphics.LinearGradient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webservice1.Model.Model
import com.example.webservice1.Model.ResponseModel
import com.example.webservice1.Retrofit.ApiClient
import com.example.webservice1.adapter.adapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog
    var dataList = ArrayList<Model>()
    private lateinit var customAdapter: adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createProgressDialog()

        setupRecyclerView()


        btn_clickme.setOnClickListener(){

            getPostsData()
            btn_clickme.visibility=View.GONE
        }

    }

    // Create progress dialog
    private fun createProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please wait while we are fetching post...")
        progressDialog.setCancelable(false)
    }

    // Setup the recycler view
    // and attach adapter to it
    private fun setupRecyclerView() {
        // Set layout for RecyclerView
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        customAdapter = adapter(this, dataList)
        // attach adapter
        recyclerView.adapter = customAdapter
    }

    private fun getPostsData() {
        progressDialog.show()

        val call = ApiClient.getClient.getPosts()
        call.enqueue(object : retrofit2.Callback<ResponseModel>{

            override fun onFailure(call: retrofit2.Call<ResponseModel>, t: Throwable) {
                //Log.d("MainActivity", "Error is ${t.message}")
                Toast.makeText(this@MainActivity, "There is some error while getting post", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }

            override fun onResponse(
                call: retrofit2.Call<ResponseModel>,
                response: Response<ResponseModel>
            ) {
                dataList.addAll(response.body()?.posts?: ArrayList())
                recyclerView.adapter!!.notifyDataSetChanged()
                progressDialog.dismiss()
                //Log.d("MainActivity", "Data is ${responseModel.body()}")

            }

        })
    }
}