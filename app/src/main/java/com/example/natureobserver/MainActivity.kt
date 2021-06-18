package com.example.natureobserver

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // variable mySharedPreferences, defined later
    private lateinit var mySharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity", "onCreate")

        // Remove Status Bar
        if (Build.VERSION.SDK_INT < 30) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        } else {
            window.setDecorFitsSystemWindows(false)
            val controller = window.insetsController
            if (controller != null) {
                controller.hide(WindowInsets.Type.statusBars())
                controller.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
        // Initialize mySharedPreferences from SharedPreferences
        mySharedPreferences = getSharedPreferences(DataService.PREFERENCE_NAME, Context.MODE_PRIVATE)

        // Initialize observationsObjectsList from SharedPreferences/TestArray
        DataService.initObservationsObjectsList(mySharedPreferences)

        // Navigation to NewObservationActivity
        newObservationBtn.setOnClickListener {
            val intent = Intent(this, NewObservationActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Navigation to ShowAllObservationsActivity
        showAllObservationsBtn.setOnClickListener {
            val intent = Intent(this, ShowAllObservationsActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.e("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity", "onDestroy")
    }
}