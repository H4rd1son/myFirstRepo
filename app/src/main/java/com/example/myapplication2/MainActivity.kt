package com.example.myapplication2


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: View = findViewById(R.id.button1)
        val button2: View = findViewById(R.id.button2)
        val button3: View = findViewById(R.id.buttonReset)
        val button4: View = findViewById(R.id.button4)
        var count:Int=0
        val funLogs = Logs()
        val textView: TextView = findViewById(R.id.textHelloWorld)
        val edText: EditText = findViewById(R.id.editText1)
        val buttonSecondScreen: View = findViewById(R.id.buttonNextActivity)

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
        button4.setOnClickListener {
            //AlertDialog
            val builderAlert = AlertDialog.Builder(this@MainActivity)
            builderAlert.setTitle("Заголовок")
            builderAlert.setMessage("При нажатии ДА текст запишется в поле ниже, при нажатии кнопки НЕТ вернется последнее число")
            builderAlert.setPositiveButton("ДА"){dialog, which ->
                val text: String = edText.getText().toString()
                textView.setText("$text $count")
            }
            builderAlert.setNegativeButton("НЕТ"){dialog, which ->
                textView.text = "последнее число = $count"
            }
            builderAlert.setNeutralButton("ОТМЕНА"){_,_ ->
                Toast.makeText(applicationContext,"Диалог закрыт, нажата отмена",Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builderAlert.create()
            dialog.show()
            funLogs.button4Log(button4)
        }
//      кнопка перехода на второе активити используя intent
        buttonSecondScreen.setOnClickListener {
            val intent = Intent(this@MainActivity, Activity2::class.java)
            startActivity(intent)
        }
    }
}