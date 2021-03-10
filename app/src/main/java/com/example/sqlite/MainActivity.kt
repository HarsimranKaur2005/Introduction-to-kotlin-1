package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    private var Myadapter: adapter? = null
    lateinit var empName:EditText
    lateinit var EmpAddr:EditText
    lateinit var EmpPhone:EditText
    lateinit var btn_add:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        empName = findViewById(R.id.et_name)
        EmpAddr = findViewById(R.id.et_address)
        EmpPhone = findViewById(R.id.et_Phone)
        btn_add = findViewById(R.id.btn_add)



        recyclerView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        Myadapter?.setListener(this)


        var database = DatabaseBuilder.getInstance(context = this)


        btn_add.setOnClickListener(){
            Executors.newSingleThreadExecutor().execute{
                database.empDao().insertEmployee(
                        EmpEntity(
                                 name = empName.text.toString(),
                                address = EmpAddr.text.toString(),
                                phone = EmpPhone.text.toString()
                        )
                )
                var list: ArrayList<EmpEntity> = database.empDao().getAllEmployee() as ArrayList<EmpEntity>

                recyclerView.apply {
                    runOnUiThread {
                        Myadapter = adapter(list)
                        recyclerView.adapter = Myadapter
                        Toast.makeText(this@MainActivity, "Data instered successfully", Toast.LENGTH_SHORT).show()
                        empName.text.clear()
                        EmpAddr.text.clear()
                        EmpPhone.text.clear()
                    }

                }
            }
        }

    }

    override fun onItemClickDelete(position: Int) {
        var database = DatabaseBuilder.getInstance(context = this)
        database.empDao().deletebyID(position)

    }

    override fun onItemClickUpdate(position: Int, name:String, address:String, phone:String) {
        var database = DatabaseBuilder.getInstance(context = this)
        database.empDao().updateEmployee(position, name,address,phone)


    }
}


