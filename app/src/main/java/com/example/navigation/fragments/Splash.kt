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
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import kotlinx.android.synthetic.main.fragment_splash.*


class Splash : Fragment() {
lateinit var firebaseAnalytics: FirebaseAnalytics
    private val USER_TYPE = "user_type"
    private val EXISTING_USER = "existin_user"
    private val NO_USER = "no_user"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // FirebaseApp.initializeApp(requireContext())
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)

        firebaseAnalytics = Firebase.analytics

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        splashNext_btn.setOnClickListener(){
            logScreenEvent()
            checkLogin()
        }
    }

    private fun logScreenEvent() {
val eventName = "screen_opened"
        val bundle = Bundle().apply {
            putString("Screen_name",Splash::class.java.simpleName)
        }
        firebaseAnalytics.logEvent(eventName,bundle)
    }

    /**
     * check if user logged in
     * if not then redirect to login fragment
     */
    private fun checkLogin() {
        if(isUserLoggedIn()) {
            setUserLoggedInProperty()
            navigateToHome()
        }
        else{
            setUserLoggedInProperty()
            navigateToLogin()
        }
    }

    private fun setUserLoggedInProperty() {
        if (isUserLoggedIn()) {
            setDefaultProperty(getUserName())
            firebaseAnalytics.setUserProperty(USER_TYPE, EXISTING_USER)
        }
        else {
            setDefaultProperty(null)
            firebaseAnalytics.setUserProperty(USER_TYPE, NO_USER)
        }
    }

    private fun getUserName(): String? {
        val sharedPreference =activity?.getSharedPreferences(MainActivity.MY_PREFERENCES,Context.MODE_PRIVATE)
        return sharedPreference?.getString(MainActivity.NAME_KEY, "")

    }

    private fun setDefaultProperty(userName: String?) {
        val bundle = Bundle().apply {
            firebaseAnalytics.setUserProperty("user_id", userName)
        }
        firebaseAnalytics.setDefaultEventParameters(bundle)
    }


    private fun navigateToLogin() {
        findNavController().navigate(R.id.action_global_loginFragment)
    }

    private fun navigateToHome() {
   val action = SplashDirections.actionSplashToHomeFragment()
        findNavController().navigate(action)
    }

    private fun isUserLoggedIn(): Boolean {
        val sharedPreference =activity?.getSharedPreferences(MainActivity.MY_PREFERENCES,Context.MODE_PRIVATE)
        val name = sharedPreference?.getString(MainActivity.NAME_KEY, "")
        return  name != ""

    }
}