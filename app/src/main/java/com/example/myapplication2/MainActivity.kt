package com.example.myapplication2


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    var count:Int=0
    private val funcLogs = Logs()
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)

        setContentView(bindingClass.root)

        bindingClass.buttonMinus.setOnClickListener {
            count--
            bindingClass.textViewYouText.text = "нажато минус: число равно = $count"
            funcLogs.button1Log(bindingClass.buttonMinus)
        }

        bindingClass.buttonPlus.setOnClickListener {
            count++
            bindingClass.textViewYouText.text = "нажато плюс: число равно = $count"
            funcLogs.button2Log(bindingClass.buttonPlus)
        }

        bindingClass.buttonReset.setOnClickListener {
            count = 0
            bindingClass.textViewYouText.text = "нажат сброс: число равно = $count"
            funcLogs.button3Log(bindingClass.buttonReset)
        }

        bindingClass.buttonEnter.setOnClickListener {
            //AlertDialog
            val builderAlert = AlertDialog.Builder(this@MainActivity)
            builderAlert.setTitle("Заголовок")
            builderAlert.setMessage("При нажатии ДА текст запишется в поле ниже, при нажатии кнопки НЕТ вернется последнее число")
            builderAlert.setPositiveButton("ДА"){dialog, which ->
                bindingClass.textViewYouText.setText(bindingClass.editTextEnterText.getText().toString() + "$count")
                Toast.makeText(applicationContext,"Нажато ДА, ваш текст на экране",Toast.LENGTH_SHORT).show()
            }
            builderAlert.setNegativeButton("НЕТ"){dialog, which ->
                bindingClass.textViewYouText.text = "последнее число = $count"
                Toast.makeText(applicationContext,"Нажато НЕТ, последнее число на экране",Toast.LENGTH_SHORT).show()
            }
            builderAlert.setNeutralButton("ОТМЕНА"){_,_ ->
                Toast.makeText(applicationContext,"Диалог закрыт, нажата ОТМЕНА",Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builderAlert.create()
            dialog.show()
            funcLogs.button4Log(bindingClass.buttonEnter)
        }

//      кнопка перехода на второе активити используя intent
        bindingClass.buttonNextActivity.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondEmptyActivity::class.java)
            startActivity(intent)
        }
    }
}