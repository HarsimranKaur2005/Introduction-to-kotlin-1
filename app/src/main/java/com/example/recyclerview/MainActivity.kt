package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//
        var list = ArrayList<Model>()
        for(i in 1..15){
            list.add(
                    Model(
                            "Ice cream sundae",
                            "145, mall of India",
                            R.drawable.item2,
                            4,
                            "520 reviews",
                            "01 Mar 2019 11:30 AM",
                            "Rs. 180"
                    )
            )
        }
//        list.add(Model("headline1" , "address1"))
//        list.add(Model("headline2" , "address2"))
//
//        list.add(Model("headline3" , "address3"))
//
//        list.add(Model("headline4" , "address4"))
//
//        list.add(Model("headline5" , "address5"))

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        var myadapter=MyAdapter(list)
        recyclerView.adapter = myadapter
        recyclerView.layoutManager= LinearLayoutManager(this)

    }
}



