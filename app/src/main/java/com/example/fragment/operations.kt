package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [operations.newInstance] factory method to
 * create an instance of this fragment.
 */
class operations : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_operations, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Fragment-LIFE_CYCLE" , "onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Fragment-LIFE_CYCLE", "onCreate()")
    }
    override fun onStart() {
        super.onStart()
        Log.i("Fragment-LIFE_CYCLE", "onstart() ")

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("Fragment-LIFE_CYCLE", "onActivityCreated")

        val addFragmentButton = requireView().findViewById<Button>(R.id.addFragment)
        var replaceFragmentButton = requireView().findViewById<Button>(R.id.replaceFragment)
        var removeFragmentButton = requireView().findViewById<Button>(R.id.removeFragment)
        var hideFragmentButton = requireView().findViewById<Button>(R.id.hideFragment)
        var showFragmentButton = requireView().findViewById<Button>(R.id.showFragment)

        addFragmentButton.setOnClickListener {
            val fragmentmanager = fragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentmanager!!.beginTransaction()

            fragmentTransaction.add(R.id.frameLayout_fragment, addFragment(), "ADD_FRAGMENT")
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }


        replaceFragmentButton.setOnClickListener() {
            val fragmentManager = fragmentManager
            val replacefrag = fragmentManager?.findFragmentByTag("ADD_FRAGMENT")
            val fragmentTransaction = fragmentManager?.beginTransaction()

            if (replacefrag != null) {
               // println("heldijlwi")
                fragmentTransaction!!.replace(R.id.frameLayout_fragment, ReplaceFragment() , "REPLACE_FRAGMENT")
                fragmentTransaction.commit()
            }
            else{
                Toast.makeText(context, "Please click on add button ", Toast.LENGTH_SHORT).show()
            }


        }

        hideFragmentButton.setOnClickListener() {
            val fragmentManager = fragmentManager
            var hide = fragmentManager?.findFragmentByTag("REPLACE_FRAGMENT")
            val fragmentTransaction = fragmentManager?.beginTransaction()

            if (hide != null) {
                fragmentTransaction!!.hide(hide)
                fragmentTransaction.commit()
            }
            else {
                Toast.makeText(context, "Please click on replace button", Toast.LENGTH_SHORT).show()
            }
        }



        showFragmentButton.setOnClickListener(){
            val fragmentManager = fragmentManager
            var show = fragmentManager?.findFragmentByTag("REPLACE_FRAGMENT")
            val fragmentTransaction = fragmentManager?.beginTransaction()

            if(show != null && show.isHidden){
                fragmentTransaction!!.show(show)
                fragmentTransaction.commit()
            }
            else
            {
                Toast.makeText(context,"Please click on replace button", Toast.LENGTH_SHORT).show()
            }
        }

        removeFragmentButton.setOnClickListener(){
            val fragmentManager = fragmentManager
            var remove = fragmentManager?.findFragmentByTag("REPLACE_FRAGMENT")
            var fragmentTransaction = fragmentManager?.beginTransaction()

            if(remove!=null){
                fragmentTransaction!!.remove(remove)
                fragmentTransaction.commit()
            }

            else
            {
                Toast.makeText(context,"Please click replace button", Toast.LENGTH_SHORT).show()
            }
        }





    }
    override fun onStop() {
        super.onStop()
        Log.i("Fragment-LIFE_CYCLE", "onStop()")

    }

    override fun onResume() {
        super.onResume()
        Log.i("Fragment-LIFE_CYCLE", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Fragment-LIFE_CYCLE", "onPause()")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Fragment-LIFE_CYCLE", "onDestroy()")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Fragment-LIFE_CYCLE", "onDestroyView()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Fragment-LIFE_CYCLE", "onDetach()")

    }

}