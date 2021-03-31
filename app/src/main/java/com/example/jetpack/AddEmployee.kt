package com.example.jetpack

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentHostCallback
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.jetpack.ViewModel.EmpViewModel
import com.example.jetpack.database.EmpEntity
import kotlinx.android.synthetic.main.fragment_add_employee2.*
import java.lang.reflect.Array.get
import java.util.concurrent.Executors

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddEmployee.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddEmployee : Fragment() {



    lateinit var model: EmpViewModel
    //instance of mainActivity to use setmodel function that is in main activity





    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_employee2, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /**
         * click on save button on fragment to add the data in database
         */

        model= ViewModelProviders.of(this).get(EmpViewModel(activity?.application!!)::class.java)
        saveButton.setOnClickListener() {
            val name = nameInput.text.toString()
            val address = addressInput.text.toString()
            val phone = phoneInput.text.toString()
            addData(name,address,phone)
            Toast.makeText(activity!!.application, "Employee with name: $name is added successfully", Toast.LENGTH_SHORT).show()

            }
    }



    /**
     * add data through viewmodel
     */

    private fun addData( name:String,  address:String,  phone:String) {

//        Executors.newSingleThreadExecutor().execute {
//
//            val mainActivity = activity as MainActivity
//
//            if(saveButton.text.equals("Save")){
//                val employee = EmpEntity(0,name,address, phone)
//                model.InsertemployeeData(employee)
//            }
//            else{
//                val employee = EmpEntity(nameInput.getTag(nameInput.id).toString().toInt(), name, address, phone)
//                model.UpdateEmployee(employee)
//                saveButton.setText("Save")
//            }
//            mainActivity.setModel()
//
//        }


        val application = activity!!.application
        model.addEmployee(EmpEntity(
                0,
                name,
                address,
                phone

        ))

    }






    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddEmployee.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddEmployee().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}