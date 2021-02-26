package com.example.exercise2

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.URLUtil
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import java.util.*

class homePage : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        var intent = getIntent()
        var bundle = intent.getExtras()
        if (bundle != null) {
            var bundleUsername = bundle.getString("username")
            var tvuname = findViewById<TextView>(R.id.tv_username)
            tvuname.setText(bundleUsername)

            var bundleemail = bundle.getString("email")
            var tvemail = findViewById<TextView>(R.id.tv_email)
            tvemail.setText(bundleemail)

            var bundlephone = bundle.getString("number")
            var tvphone = findViewById<TextView>(R.id.tv_phone)
            tvphone.setText(bundlephone)


        }

        val eturl = findViewById<EditText>(R.id.et_url)
        val btnImplicitIntent = findViewById<Button>(R.id.btn_ImplicitIntent)
        val btnPermission = findViewById<Button>(R.id.btn_permission)

        btnImplicitIntent.setOnClickListener()
        {
            var url: String? = eturl.text.toString()

            if (URLUtil.isValidUrl(url)) {

                var implicit = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(Intent.createChooser(implicit, "Browse with"))

            } else {
                Toast.makeText(applicationContext, "Please Enter valid Url", Toast.LENGTH_SHORT).show()
            }
        }


        btnPermission.setOnClickListener {
            // It will check if permission is already
            // granted or not
            val value =
                    ContextCompat.checkSelfPermission(this, "android.permission.CAMERA")
            when (value) {
                PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(this, "Camera permission already granted!", Toast.LENGTH_LONG)
                            .show()
                    Log.e("USER_PERMISSION", "PERMISSION_GRANTED")
                    //no need for permission, do the operation
                }
                // Permission not already given
                PackageManager.PERMISSION_DENIED -> {
                    Log.e("USER_PERMISSION", "PERMISSION_DENIED")
                    //ask for permission
                    askForPermission()
                }
            }
        }
    }

    private fun askForPermission() {
        val permissions = arrayOf("android.permission.CAMERA")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, 1001)
        }
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1001) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission granted
                Toast.makeText(this, "Camera permission granted!", Toast.LENGTH_LONG).show()
                Log.e("USER_PERMISSION", "PERMISSION_GRANTED ${permissions[0]}")
            } else {
                // permission denied
                Toast.makeText(this, "Camera permission denied. You can change this from settings.", Toast.LENGTH_LONG)
                        .show()
                Log.e("USER_PERMISSION", "PERMISSION_DENIED ${permissions[0]}")
            }
        }
    }
}