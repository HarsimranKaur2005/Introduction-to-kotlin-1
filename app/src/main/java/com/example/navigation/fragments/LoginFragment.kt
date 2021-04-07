package com.example.navigation.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigation.MainActivity
import com.example.navigation.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    lateinit var firebaseAnalytics: FirebaseAnalytics
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        firebaseAnalytics = Firebase.analytics
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loginBTN.setOnClickListener(){
            val name = name_et.text.toString()
            if (!name.isEmpty()){
                saveNameInSharedPref(name)
                navigatetoHomeDestination()
            }
            else
            {
                name_et.error = "you must enter a name"
            }
        }

        logScreenEvent()
    }

    private fun logScreenEvent() {
        val eventName = "screen_opened"
        val bundle = Bundle().apply {
            putString("Screen_name",Splash::class.java.simpleName)
        }
        firebaseAnalytics.logEvent(eventName,bundle)

    }

    /**
     * Navigate to destination
     */
    private fun navigatetoHomeDestination() {
        val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
        findNavController().navigate(action)


    }

    private fun saveNameInSharedPref(name: String) {
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putString(MainActivity.NAME_KEY, name)
        editor?.apply()


    }
}