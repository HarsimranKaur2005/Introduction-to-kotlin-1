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
import kotlinx.android.synthetic.main.fragment_splash.*


class Splash : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        splashNext_btn.setOnClickListener(){
            checkLogin()
        }
    }

    /**
     * check if user logged in
     * if not then redirect to login fragment
     */
    private fun checkLogin() {
        if(isUserLoggedIn())
            navigateToHome()
        else{
            navigateToLogin()
        }
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