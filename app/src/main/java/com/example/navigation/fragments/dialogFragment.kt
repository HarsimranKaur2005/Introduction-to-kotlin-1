package com.example.navigation.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.MainActivity
import com.example.navigation.R
import kotlinx.android.synthetic.main.fragment_home.*


class dialogFragment : DialogFragment() {

    //Get argument using Safe args
   // val args: di
    val args: dialogFragmentArgs by navArgs()

    lateinit var navController: NavController
    private val TAG = dialogFragment::class.java.simpleName
    lateinit var description:EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        navController = findNavController()
        //get data using safe args

        val title = args.dialogFragmentTitle

        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val dialogLayout=inflater.inflate(R.layout.fragment_dialog,null)
        description = dialogLayout.findViewById(R.id.dialogDesc_ET)

        return builder
        //Inflate and set the layout for the dialog
        //pass null as the parent view bcoz its going in the dialog layout
                .setView(dialogLayout)
                .setTitle(title)
                .setCancelable(false)
                .setPositiveButton("submi"){dialog, which ->
                    getDiscriptionFromDialog()
                }
                .create()
    }

    private fun getDiscriptionFromDialog() {
        var desc = description.text.toString()
        if (!desc.isEmpty()){
            navController.previousBackStackEntry?.savedStateHandle?.set(
                    MainActivity.DESCRIPTION_KEY,
                    desc
            )
        } else{
            navController.previousBackStackEntry?.savedStateHandle?.set(
                    MainActivity.DESCRIPTION_KEY,"you must enter description"
            )

            Toast.makeText(
                    context,
                    "you must enter description",
                    Toast.LENGTH_SHORT

            ).show()
        }
    }


}