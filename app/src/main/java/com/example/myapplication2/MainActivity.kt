package com.example.myapplication2


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var count:Int=0
    private val funLogs = Logs()
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)

//        setContentView(R.layout.activity_main)
        setContentView(bindingClass.root)

        val buttonMinus: View = findViewById(R.id.button1)
        val buttonPlus: View = findViewById(R.id.button2)
//        val buttonReset: View = findViewById(R.id.buttonReset)
        val buttonEnter: View = findViewById(R.id.button4)
        val textView: TextView = findViewById(R.id.textHelloWorld)
        val edText: EditText = findViewById(R.id.editText1)
        val buttonSecondScreen: View = findViewById(R.id.buttonNextActivity)

        buttonMinus.setOnClickListener {
            count--
            textView.text = "нажато минус: число равно = $count"
            funLogs.button1Log(buttonMinus)
        }
        buttonPlus.setOnClickListener {
            count++
            textView.text = "нажато плюс: число равно = $count"
            funLogs.button2Log(buttonPlus)
        }
        bindingClass.buttonReset.setOnClickListener {
            count = 0
            bindingClass.textHelloWorld.text = "нажат сброс: число равно = $count"
            funLogs.button3Log(bindingClass.buttonReset)
        }
        /*buttonReset.setOnClickListener {
            count = 0
            textView.text = "нажат сброс: число равно = $count"
            funLogs.button3Log(buttonReset)
        }*/
        buttonEnter.setOnClickListener {
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
            funLogs.button4Log(buttonEnter)
        }
//      кнопка перехода на второе активити используя intent
        buttonSecondScreen.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondEmptyActivity::class.java)
            startActivity(intent)
        }
    }
}