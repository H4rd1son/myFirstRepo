package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: View = findViewById(R.id.button1)
        val button2: View = findViewById(R.id.button2)
        val button3: View = findViewById(R.id.buttonReset)
        var a:Int=0
        val funLogs = Logs()
        val textView: TextView = findViewById(R.id.textHelloWorld)

        button1.setOnClickListener {
            a--
            textView.text = "нажато минус: число равно = $a"
            funLogs.button1Log(button1)
        }
        button2.setOnClickListener {
            a++
            textView.text = "нажато плюс: число равно = $a"
            funLogs.button2Log(button2)
        }
        button3.setOnClickListener {
            a = 0
            textView.text = "нажат сброс: число равно = $a"
            funLogs.button3Log(button3)
        }
    }
}