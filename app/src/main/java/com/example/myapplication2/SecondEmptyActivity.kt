package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class SecondEmptyActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "SecondEmptyActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_empty_activity)

        Log.d(TAG, "onCreate")

        val buttonFirstScreen: View = findViewById(R.id.buttonPreviousActivity)
        buttonFirstScreen.setOnClickListener {
            val intent = Intent(this@SecondEmptyActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }
}