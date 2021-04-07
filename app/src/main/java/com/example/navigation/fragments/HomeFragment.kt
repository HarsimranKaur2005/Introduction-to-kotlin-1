package com.example.navigation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.navigation.MainActivity
import com.example.navigation.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private val MY_PREFERENCES = MainActivity.MY_PREFERENCES
    private val NAME_KEY = MainActivity.NAME_KEY
    private lateinit var navController: NavController
    private val TAG = HomeFragment::class.java.simpleName
    lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        firebaseAnalytics = Firebase.analytics
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        logScreenEvent()
        navController = findNavController()
        checkLogin()
        setListeners()
        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<String>(MainActivity.DESCRIPTION_KEY)
                ?.observe(viewLifecycleOwner, Observer {
                    // Do something with result
                    Log.i(TAG, "Description is $it")
                    logDescriptionUpdatesEvent()
                    updateUIForDescription(it)
                })
    }

    private fun logScreenEvent() {
        val eventName = "screen_opened"
        val bundle = Bundle().apply {
            putString("Screen_name",HomeFragment::class.java.simpleName)
        }
        firebaseAnalytics.logEvent(eventName,bundle)
    }

    private fun logDescriptionUpdatesEvent() {
        val eventName = "description_updates"
        val bundle = Bundle().apply {
            putString("decription_changed","yes")
        }
        firebaseAnalytics.logEvent(eventName,bundle)
    }

    private fun updateUIForDescription(description: String) {
        descriptionTV.text = description
    }

    /**
     * Check if user logged in
     * If not then redirect to Login fragment
     */
    private fun checkLogin() {
        if (isUserLoggedIn())
        // Do nothing as user is logged in
        else {
            Toast.makeText(activity, "you must enter the info", Toast.LENGTH_LONG)
                    .show()
            navigateToLoginDestination()
        }
    }

    private fun isUserLoggedIn(): Boolean {
        val sharedPreferences = activity?.getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE)
        val name = sharedPreferences?.getString(NAME_KEY, "")
        return name != ""
    }

    private fun setListeners() {
        openAccountBTN.setOnClickListener {
            navigateToAccountDestination()
        }

        addDescBTN.setOnClickListener {
            if (!isTitleEntered()) {
                val title = titleET.text.toString()
                navigateToInputDescriptionDialogFragmentDestination(title)
            } else {
                titleET.error = "You must enter title"
            }
        }
    }

    private fun navigateToInputDescriptionDialogFragmentDestination(title: String) {
        // Navigate to a destination
        val action =
                HomeFragmentDirections.actionHomeFragmentToDialogFragment(title) // Sending data using Safe args
        navController.navigate(action)
    }

    private fun isTitleEntered(): Boolean {
        return titleET.text.toString().isEmpty()
    }

    private fun navigateToAccountDestination() {
        // Navigate to a destination
        val action =
                HomeFragmentDirections.actionHomeFragmentToAccountFragment2()
        navController.navigate(action)
    }

    private fun navigateToLoginDestination() {
        // Navigate to a destination
        navController.navigate(R.id.action_global_loginFragment)
    }
}

