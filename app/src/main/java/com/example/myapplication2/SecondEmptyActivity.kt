package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class SecondEmptyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_empty_activity)

        val buttonFirstScreen: View = findViewById(R.id.buttonPreviousActivity)
        buttonFirstScreen.setOnClickListener {
            val intent = Intent(this@SecondEmptyActivity, MainActivity::class.java)
            startActivity(intent)
        }
        val funLogs = Logs()
        val textView: TextView = findViewById(R.id.textHelloWorld)
        var count:Int=0
        val button3: View = findViewById(R.id.buttonReset)
        button3.setOnClickListener {
            count = 0
            textView.text = "нажат сброс: число равно = $count"
            funLogs.button3Log(button3)
        }
        val edText: EditText = findViewById(R.id.editText1)
        val button4: View = findViewById(R.id.button4)
        button4.setOnClickListener {
            //AlertDialog
            val builderAlert = AlertDialog.Builder(this@SecondEmptyActivity)
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
                Toast.makeText(applicationContext,"Диалог закрыт, нажата отмена", Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builderAlert.create()
            dialog.show()
            funLogs.button4Log(button4)
        }
    }
}