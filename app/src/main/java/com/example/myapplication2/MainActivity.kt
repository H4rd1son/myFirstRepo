package com.example.myapplication2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: View = findViewById(R.id.button1)
        val button2: View = findViewById(R.id.button2)
        val button3: View = findViewById(R.id.buttonReset)
        var count:Int=0
        val funLogs = Logs()
        val textView: TextView = findViewById(R.id.textHelloWorld)

        button1.setOnClickListener {
            count--
            textView.text = "нажато минус: число равно = $count"
            funLogs.button1Log(button1)
        }
        button2.setOnClickListener {
            count++
            textView.text = "нажато плюс: число равно = $count"
            funLogs.button2Log(button2)
        }
        button3.setOnClickListener {
            count = 0
            textView.text = "нажат сброс: число равно = $count"
            funLogs.button3Log(button3)
        }
        val edText: EditText = findViewById(R.id.editText1)
        val button4: View = findViewById(R.id.button4)
        button4.setOnClickListener {
            val text: String = edText.getText().toString()
            textView.setText("$text $count")
        }
    }
}