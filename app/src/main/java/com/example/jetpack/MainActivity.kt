package com.example.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.ViewModel.EmpViewModel
import com.example.jetpack.adapter.adapter
import com.example.jetpack.database.EmpEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_add_employee2.*
import java.util.concurrent.Executors
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {
    lateinit var model:EmpViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var Myadapter: adapter
    lateinit var frag:Fragment
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setRecyclerView()
        setModel()

         frag = AddEmployee()

        //add fragment
        floatingbtn.setOnClickListener(){
            var fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            fragmentTransaction.add(R.id.fragment, frag, "fragment added")
             fragmentTransaction.addToBackStack("added").commit()

            fragment.visibility=View.VISIBLE
            recyclerView.visibility=View.INVISIBLE
        }

    }

    /*
    set the recyclerview
     */

    private fun setRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            Myadapter= adapter(this@MainActivity)
            adapter = Myadapter
        }
    }

    /**
     * Instantiate viewmodel and observe employee
     */

    fun setModel() {
        Executors.newSingleThreadExecutor().execute {
            model= ViewModelProviders.of(this).get(EmpViewModel(application)::class.java)
            runOnUiThread {
                model!!.getAllEmpObserver().observe(this, Observer {

                    fragment.visibility=View.INVISIBLE
                    recyclerView.visibility=View.VISIBLE

                    Myadapter.setListData(ArrayList(it))
                    Myadapter.notifyDataSetChanged()


                })



            }

        }
    }

}



