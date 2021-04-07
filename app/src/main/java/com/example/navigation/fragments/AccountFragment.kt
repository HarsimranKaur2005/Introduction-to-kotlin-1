package com.example.navigation.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.navigation.MainActivity
import com.example.navigation.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_login.*


class AccountFragment : Fragment() {

    lateinit var firebaseAnalytics: FirebaseAnalytics


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        firebaseAnalytics = Firebase.analytics
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logScreenEvent()
        checkLogin()
        getSharedPref()
        setListeners()
    }

    private fun logScreenEvent() {
        val eventName = "screen_opened"
        val bundle = Bundle().apply {
            putString("Screen_name",AccountFragment::class.java.simpleName)
        }
        firebaseAnalytics.logEvent(eventName,bundle)
    }

    /**
     * Check if user logged in
     * If not then redirect to Login fragment
     */
    private fun checkLogin() {
        if (isUserLoggedIn()) {
            val name = getSharedPref()
            name_TV.text = "Welcome " + name.toString()
        } else {
            Toast.makeText(activity, "You must enter a name", Toast.LENGTH_LONG).show()
            navigateToLoginDestination()
        }
    }

    private fun isUserLoggedIn(): Boolean {
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        val name = sharedPreferences?.getString(MainActivity.NAME_KEY, null)
        return name != null
    }

    private fun getSharedPref(): String? {
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences?.getString(MainActivity.NAME_KEY, null)
    }

    private fun setListeners() {
        logout_btn.setOnClickListener {
            removeSharedPrefData()
            navigateToLoginDestination()
        }
    }

    private fun navigateToLoginDestination() {
        findNavController().navigate(R.id.action_global_loginFragment)
    }

    private fun removeSharedPrefData() {
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        val sharedPreferencesEditor = sharedPreferences?.edit()
        sharedPreferencesEditor?.remove(MainActivity.NAME_KEY)
        sharedPreferencesEditor?.apply()
    }
}
