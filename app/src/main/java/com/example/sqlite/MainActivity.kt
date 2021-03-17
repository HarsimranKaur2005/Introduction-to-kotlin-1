package com.example.sqlite

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.StringBuilder
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
    lateinit var textView: TextView
    lateinit var btn_cv:Button
    val contactHashMap = HashMap<String,String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//
        btn_add = findViewById(R.id.btn_add)
        btn_cv = findViewById(R.id.btn_cv)
        textView=findViewById(R.id.listContacts)

       //content provider
        btn_cv.setOnClickListener(){

            //show the textview when this button is clicked
            //and hide the recyclerview
            recyclerView.visibility=View.GONE
            textView.visibility=View.VISIBLE
            loadContacts()
        }


        addSampleData()
        startRecyclerView()

            }

    private fun loadContacts() {

        var builder = StringBuilder()
        //check for permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(
                        android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(arrayOf(android.Manifest.permission.READ_CONTACTS),101)
        }
        else{

            val contacts = getContacts()
                for(c in contacts) {
                    textView.text = contacts.toString()

                }
                Toast.makeText(this, "contact has been added successfully", Toast.LENGTH_SHORT).show()
            }
        }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray) {
        if (requestCode == 101) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadContacts()
            } else {
                //  toast("Permission must be granted in order to display contacts information")
                Toast.makeText(this, "Allow the permission from settings", Toast.LENGTH_LONG).show()
            }
        }
    }


    /// content provider to get contacts

    private fun getContacts(): StringBuilder {
        val builder = StringBuilder()
        val contentResolver = contentResolver
        val cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)
        if (cursor!!.count>0){
            while (cursor.moveToNext()){
                val id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                val phone = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)).toInt()

                if (phone>0){
                    val cursorPhone = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone._ID + "=?", arrayOf(id),
                            null)

                    if (cursorPhone!!.count > 0){
                        while (cursorPhone.moveToNext()){
                            val phoneValue = cursorPhone.getString(
                                    cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                            )

                          builder.append("Contact: ").append(name).append("\n\n").append("Phone Number: "
                          ).append(phoneValue).append("\n\n")
                        }
                    }
                    cursorPhone.close()
                }
            }

        }
        else{
            Toast.makeText(this,"No contacts available", Toast.LENGTH_SHORT).show()
        }
        cursor.close()
        return builder

    }


    //data for room database
    private fun addSampleData() {
        var database = DatabaseBuilder.getInstance(context = this)


        btn_add.setOnClickListener(){
            recyclerView.visibility=View.VISIBLE
            textView.visibility=View.GONE
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

                //initialise recyclerview and set adapter
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


