package com.example.multipleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val mylist = mutableListOf<Int>()
    private var page =1
    private  var isLoading = false
    private val limit= 4

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter
    private lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         recyclerView = findViewById(R.id.recyclerView)

        layoutManager  = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager

        getPage()


        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy>0){
                    val visibleItemCount = layoutManager.childCount
                    val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                    val total=layoutManager.itemCount

                    if(!isLoading)
                    {
                        if((visibleItemCount + pastVisibleItem) >= total)
                            page++
                        getPage()
                    }
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    fun getPage(){
        isLoading = true


        var progressBar =  findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility= View.VISIBLE

        val start = (page-1)*limit
        val end = page*limit

        for(i in start .. end){

            when{
                i%2==0->{
                    mylist.add(MyAdapter.TEXT_VIEW)
                }
                i%3==0->{
                    mylist.add(MyAdapter.IMAGE_VIEW)
                }
                else->{
                    mylist.add(MyAdapter.IMAGE_TEXT_VIEW)
                }
            }
        }
        Handler().postDelayed({
            if (this::myAdapter.isInitialized){
                myAdapter.notifyDataSetChanged()
            }
            else{
                myAdapter= MyAdapter(this,mylist)
                recyclerView.adapter = myAdapter
            }
            isLoading = false
            progressBar.visibility= View.GONE

        },3000)

//        val listViewType = mutableListOf( MyAdapter.TEXT_VIEW,
//        MyAdapter.IMAGE_VIEW,
//        MyAdapter.IMAGE_TEXT_VIEW,
//            MyAdapter.IMAGE_VIEW,
//            MyAdapter.IMAGE_TEXT_VIEW,
//        MyAdapter.IMAGE_VIEW,
//        MyAdapter.IMAGE_TEXT_VIEW)


//        val adapterRecyclerView = MyAdapter(this, listViewType)
//        recyclerView.adapter=adapterRecyclerView

    }
}