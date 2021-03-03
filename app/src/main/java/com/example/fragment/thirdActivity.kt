package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceFragment
import androidx.preference.PreferenceFragmentCompat

class thirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

     supportFragmentManager
             .beginTransaction()
             .add(R.id.prefFrameLayout, prefFragment())
             .commit()
          }
    }


     class prefFragment : PreferenceFragmentCompat() {
         override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
             setPreferencesFromResource(R.xml.preference,rootKey)
         }


    }


