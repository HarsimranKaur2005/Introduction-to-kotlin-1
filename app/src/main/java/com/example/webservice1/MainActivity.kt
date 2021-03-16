package com.example.webservice1

import android.app.ProgressDialog
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.webservice1.Model.Model
import com.example.webservice1.Retrofit.ApiClient
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog
    lateinit var id:TextView
    lateinit var title:TextView
    lateinit var body:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createProgressDialog()

        var enterText = findViewById<EditText>(R.id.et_enterText)
        var Submit  = findViewById<Button>(R.id.btn_submit)
        id = findViewById(R.id.tv_id)
        title = findViewById(R.id.tv_title)
        body = findViewById(R.id.tv_body)

        Submit.setOnClickListener(){
            val text = enterText.text
            if (text.isNullOrBlank() || text.toString().toInt() >10 || text.toString().toInt()<1)
            {
                enterText.error = "Value entered should be between 1-10"
            } else{
                progressDialog.show()
                getData(text.toString().toInt())
            }
        }
    }

    private fun getData(postId: Int) {
    val call = ApiClient.getClient.getPost(postId)
        call.enqueue(object : retrofit2.Callback<List<Model>>{
            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                Log.i("MainActivity", "Error is ${t.localizedMessage}")
                Toast.makeText(this@MainActivity, "There is some error", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }

            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                progressDialog.dismiss()
                Log.d("MainActivity", "Data is ${response.body()}")
                for (data in response.body()!!)
                {
                    id.text = "ID: ${data.postId.toString()}"
                    title.text = "Title: ${data.postTitle.toString()}"
                    body.text = "Body: ${data.postBody.toString()}"
                }
            }


        })

    }

    private fun createProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please wait for a while...")
        progressDialog.setCancelable(false)   }
}