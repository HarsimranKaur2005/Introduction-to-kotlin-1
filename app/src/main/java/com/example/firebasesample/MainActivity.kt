package com.example.firebasesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.StatsLog.logEvent
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.google.firebase.perf.FirebasePerformance
import com.google.firebase.perf.metrics.AddTrace
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    val myTrace= FirebasePerformance.getInstance().newTrace("testTrace")
    private lateinit var firebaseAnalytics:FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Log.d("onCreate", "${intent.extras?.getString("custom_data")}")
//
//        firebaseAnalytics = Firebase.analytics
//
//        myFunction()
//      click.setOnClickListener(){
////          setUpUserProperty()
////          setUser()
////          setDefaultParameters()
////          CustomlogEvent()
//
//          throw  RuntimeException("crash")
//
//      }



        val imageURL = getCustomDataFromFCM()
        if (imageURL != null) {
            updateUI(imageURL)
        } else {
            Toast.makeText(this, "Make sure notification has correct image URL", Toast.LENGTH_SHORT)
                .show()
        }
    }

    /**
     * Update the UI/Update the Image as per received URL
     */
    private fun updateUI(imageURL: String) {
        Glide
            .with(this)
            .load(imageURL)
            .into(imageView)
    }

    private fun getCustomDataFromFCM(): String? {
        Log.i(TAG, "${ intent.extras?.getString(demoService.IMAGE_URL_KEY) }")
        return intent.extras?.getString(demoService.IMAGE_URL_KEY)
    }

//    @AddTrace(name = "startFun")
//    override fun onStart() {
//        super.onStart()
//    }
//    private fun myFunction() {
//        myTrace.start()
//        myTrace.incrementMetric("hit", 1)
//
//
//
//        myTrace.stop()
//    }
//
//    private fun CustomlogEvent() {
//        // custom event
//        val eventName2 = "share_image"
//        val bundle2 = Bundle().apply {
//           putString("image_name", "some_name")
//            putString("image_description", "some_text")
//        }
//
//        firebaseAnalytics.logEvent(eventName2, bundle2)
//    }
//    private fun setUpUserProperty() {
//        firebaseAnalytics.setUserProperty("location", "INDIA")
//        firebaseAnalytics.setUserProperty("currency", "INR")
//        firebaseAnalytics.setUserProperty("is_subscribe", "false")
//    }
//
//    private fun setDefaultParameters() {
//        val parameters = Bundle().apply {
//            putString(FirebaseAnalytics.Param.LOCATION, "INDIA")
//            putString(FirebaseAnalytics.Param.CURRENCY, "INR")
//        }
//
//        firebaseAnalytics.setDefaultEventParameters(parameters)
//    }
//    private fun setUser(){
//        firebaseAnalytics.setUserId("123")
//    }

}