package com.example.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class DialogClass : DialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootview:View = inflater.inflate(R.layout.activity_dialog,container,false)
        var backbuttoon = rootview.findViewById<Button>(R.id.dialog_button)
        backbuttoon.setOnClickListener(){
            dismiss()
        }
        return rootview
    }
}