package com.example.natureobserver

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_new_observation.*
import java.util.*

class NewObservationActivity : AppCompatActivity(), View.OnClickListener {

    private var calendar = Calendar.getInstance()
    private lateinit var dateSetListener: DatePickerDialog.OnDateSetListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_observation)
        Log.e("NewObservationActivity", "onCreate")

        dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInView()
        }
        etDate.setOnClickListener(this)

        newObservationSaveBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun updateDateInView(){
        val myFormat = "dd.MM.yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.getDefault())
        etDate.setText(sdf.format(calendar.time).toString())
    }

    override fun onStart() {
        super.onStart()
        Log.e("NewObservationActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("NewObservationActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("NewObservationActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("NewObservationActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("NewObservationActivity", "onDestroy")
    }

    override fun onClick(v: View?) {
        when (v!!.id){
            R.id.etDate -> {
                DatePickerDialog(this@NewObservationActivity, dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show()
            }
        }
    }

}