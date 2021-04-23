package com.example.newsfeedapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsfeedapp.Model.ApiClient
import com.example.newsfeedapp.Model.News
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var progressDialog: ProgressDialog
    var dataList = ArrayList<News>()
    private lateinit var customAdapter:Adapter
    private val KEY = "89896b6d8022bcb6ed0dd3a3c47c15ba"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createProgressDialog()

        setupUI()

        getData()
    }

    private fun getData() {


//        progressDialog.show()

        val call = ApiClient.getClient.getNews(KEY,"en")
        call.enqueue(object :retrofit2.Callback<ResponseModel>{
            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(this@MainActivity,
                "there is some error while getting data",
                Toast.LENGTH_SHORT).show()
               // progressDialog.dismiss()
            }

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
            dataList.addAll(response.body()?.data?:ArrayList())
                Log.i("MainActivity", "data is: ${dataList}\n\n")
                recyclerView.adapter!!.notifyDataSetChanged()
               // progressDialog.dismiss()
            }

        })
    }

    private fun setupUI() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager

       customAdapter = Adapter(this, dataList)
        recyclerView.adapter=customAdapter
    }

    //create progress dialog
    private fun createProgressDialog() {
         progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please wait while we are fetching the data")
        progressDialog.setCancelable(false)
    }
}




