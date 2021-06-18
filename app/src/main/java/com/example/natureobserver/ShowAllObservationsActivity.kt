package com.example.natureobserver

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_show_all_observations.*
import kotlinx.android.synthetic.main.activity_show_all_observations.newObservationBackBtn

class ShowAllObservationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_observations)
        Log.e("ShowAllObservationsActivity", "onCreate")

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

        // RecyclerView
        val myLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        var myAdapter = RvObservationAdapter(DataService.observationsObjectsList)
        val divider = DividerItemDecoration(this, myLayoutManager.orientation)
        rvObservations.adapter = myAdapter
        rvObservations.layoutManager = myLayoutManager
        rvObservations.addItemDecoration(divider)

        // Return Button ClickListener
        newObservationBackBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.e("ShowAllObservationsActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("ShowAllObservationsActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("ShowAllObservationsActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("ShowAllObservationsActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("ShowAllObservationsActivity", "onDestroy")
    }
}