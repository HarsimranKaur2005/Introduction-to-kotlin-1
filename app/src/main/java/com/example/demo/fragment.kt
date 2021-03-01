package com.example.demo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment : Fragment() {
//    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null

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
        Log.i("Fragment-LIFE_CYCLE", "onCreateview()")
        return inflater.inflate(R.layout.fragment_fragment, container, false)
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


        //all buttons

        val addFragmentButton = view!!.findViewById<Button>(R.id.addFragment)
        var replaceFragmentButton = view!!.findViewById<Button>(R.id.replaceFragment)
        var removeFragmentButton = view!!.findViewById<Button>(R.id.removeFragment)
        var hideFragmentButton = view!!.findViewById<Button>(R.id.hideFragment)
        var showFragmentButton = view!!.findViewById<Button>(R.id.showFragment)
        var dialogButton = view!!.findViewById<Button>(R.id.dialogFragment)

        addFragmentButton.setOnClickListener {
            val fragmentmanager = fragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentmanager!!.beginTransaction()

            fragmentTransaction.add(R.id.frameLayout_fragment, secondFragment(), "second_fragment")
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }




        replaceFragmentButton.setOnClickListener() {
            val fragmentManager = fragmentManager
            val replacefrag = fragmentManager?.findFragmentByTag("second_fragment")
            val fragmentTransaction = fragmentManager?.beginTransaction()

            if (replacefrag != null) {
                fragmentTransaction!!.replace(R.id.frameLayout_fragment, thirdFragment(), "ThirdFragment")
                fragmentTransaction.commit()
            }
            else{
                Toast.makeText(context, "add fragment first", Toast.LENGTH_SHORT).show()
            }


        }


        removeFragmentButton.setOnClickListener(){
            val fragmentManager = fragmentManager
            var remove = fragmentManager?.findFragmentByTag("ThirdFragment")
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

        hideFragmentButton.setOnClickListener(){
            val fragmentManager = fragmentManager
            var hide = fragmentManager?.findFragmentByTag("ThirdFragment")
//          hide = fragmentManager?.findFragmentByTag("second_fragment")
            val fragmentTransaction = fragmentManager?.beginTransaction()

            if (hide != null)
            {
                fragmentTransaction!!.hide(hide)
                fragmentTransaction.commit()
            }
            else
            {Toast.makeText(context,"Please click on replace button", Toast.LENGTH_SHORT).show()}

        }

        showFragmentButton.setOnClickListener(){
            val fragmentManager = fragmentManager
            var show = fragmentManager?.findFragmentByTag("ThirdFragment")
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


//        dialogButton.setOnClickListener(){
//
//            val pop = DialogFragment()
//            val fm = fragmentManager
//
//
//          //  pop.show(fm, "Simple Fragment")
//
//
//        }

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

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment fragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            fragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}