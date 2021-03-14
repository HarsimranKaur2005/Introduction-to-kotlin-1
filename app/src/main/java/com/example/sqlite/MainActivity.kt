package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.Executors
import kotlin.collections.ArrayList
import kotlin.collections.List as List1

class MainActivity : AppCompatActivity(),adapter.OnItemClickListener {
    lateinit var recyclerView: RecyclerView
    lateinit var list: List1<EmpEntity>
    private lateinit var Myadapter:adapter
    lateinit var empName:EditText
    lateinit var EmpAddr:EditText
    lateinit var EmpPhone:EditText
    lateinit var btn_add:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        empName = findViewById(R.id.et_name)
//        EmpAddr = findViewById(R.id.et_address)
//        EmpPhone = findViewById(R.id.et_Phone)
        btn_add = findViewById(R.id.btn_add)

        addSampleData()
        startRecyclerView()

            }


    private fun addSampleData() {
        var database = DatabaseBuilder.getInstance(context = this)


        btn_add.setOnClickListener(){
            Executors.newSingleThreadExecutor().execute {
                database.empDao().insertEmployee(
                        EmpEntity(
                                name = "Harsimran Kaur",
                                address = "delhi",
                                phone = "9818134934"
                        )
                )
                database.empDao().insertEmployee(
                        EmpEntity(
                                name = "Lakshay",
                                address = "noida",
                                phone = "298723847"
                        )
                )
                database.empDao().insertEmployee(
                        EmpEntity(
                                name = "Vishal",
                                address = "dwaka",
                                phone = "2355456754"
                        )

                )
                //startRecyclerView()

                DisplaySampleData()
            }

        }
    }


    private fun startRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        var layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager

    }

    private fun DisplaySampleData() {
        var empList: ArrayList<EmpEntity>
        val database = DatabaseBuilder.getInstance(this)
        Executors.newSingleThreadExecutor().execute {

            //get data from Database
            empList = database.empDao().getAllEmployee() as ArrayList<EmpEntity>

            recyclerView.apply {
                runOnUiThread{
                    Myadapter = adapter(this@MainActivity, empList)
                    Myadapter.setListener(this@MainActivity)

                    recyclerView.adapter = Myadapter

                    Myadapter.notifyDataSetChanged()}

            }
        }
    }

    override fun onItemClickDelete(position: Int, id:Int) {
        var database = DatabaseBuilder.getInstance(context = this)
        Executors.newSingleThreadExecutor().execute {
            database.empDao().deleteEmployee(EmpEntity(id = id))
        }
        Toast.makeText(this, "Employee with id $id is deleted", Toast.LENGTH_SHORT).show()


    }

    override fun onItemClickUpdate(position: Int, name:String, address:String, phone:String, id:Int) {

        Log.i("Data", "=== *** Name: $name, Contact: $phone, Address: $address ===")

        var database = DatabaseBuilder.getInstance(context = this)
        Executors.newSingleThreadExecutor().execute {
            database.empDao().updateEmployee(
                    EmpEntity(
                            id = id,
                            name = name,
                            address = address,
                            phone = phone

                    ))
        }




    }
}


