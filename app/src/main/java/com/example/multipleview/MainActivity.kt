package com.example.multipleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val listViewType2 = mutableListOf<Int>()

    private var startPage = 1
    private var isLoading = false
    private val limit = 4

    private var progressBar : ProgressBar? = null

    private lateinit var recyclerView2: RecyclerView
    private lateinit var multiViewRecyclerAdapter: MyAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById<ProgressBar>(R.id.progressBar)


        recyclerView2 = findViewById(R.id.recyclerView)

        layoutManager = LinearLayoutManager(applicationContext)
        recyclerView2.layoutManager = layoutManager

        multiViewRecyclerAdapter = MyAdapter(this, listViewType2)
        recyclerView2.adapter = multiViewRecyclerAdapter

        //getPage()
        getPage()
        //checkForPagination()
        Handler().post({checkForPagination()})

        recyclerView2.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView2: RecyclerView, dx: Int, dy: Int) {

                // dy means vertical scroll position
                if (dy > 0) {
                    Log.e("value of dy" , "dy " + dy )
                    checkForPagination()
                }
                super.onScrolled(recyclerView2, dx, dy)
            }
        })
    }

    private fun getPage() {

        Log.e("get Page TAG", startPage.toString())
        // When loading
        // show progressBar


        // For endless scrolling
        addDataInList()
        // Adding delay of 2 seconds

        progressBar!!.visibility = View.GONE

        multiViewRecyclerAdapter.notifyDataSetChanged()
        isLoading = false


    }
    private fun checkForPagination(){
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        // use isLastPage to stop when last page shown
        // to the users
        Log.e("Scrolled View variables", "visibleItemCount" + visibleItemCount)
        Log.e("Scrolled View variables", "totalItemCount" + totalItemCount)
        Log.e("Scrolled View variables", "firstVisibleItemPosition" + firstVisibleItemPosition)
        if (!isLoading) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                startPage++
                progressBar!!.visibility = View.VISIBLE
                isLoading = true
                Handler().postDelayed({getPage()}, 2000)
            }
        }
    }


    private fun addDataInList(){
        val start = (startPage - 1) * limit
        val end = (startPage) * limit
        //val start = 1
        //val end = 5

        for (i in start..end) {
            when {
                i % 2 == 0 -> {
                    listViewType2.add(MyAdapter.TEXT_VIEW)
                }
                i % 3 == 0 -> {
                    listViewType2.add(MyAdapter.IMAGE_VIEW)
                }
                else -> {
                    listViewType2.add(MyAdapter.IMAGE_TEXT_VIEW)
                }
            }
        }
    }
}
