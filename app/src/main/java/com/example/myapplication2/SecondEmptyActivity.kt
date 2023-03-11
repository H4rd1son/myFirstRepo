package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.myapplication2.databinding.ActivityMainBinding
import com.example.myapplication2.databinding.SecondEmptyActivityBinding

class SecondEmptyActivity : AppCompatActivity() {

    lateinit var bindingClass : SecondEmptyActivityBinding

    companion object {
        private const val TAG = "SecondEmptyActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = SecondEmptyActivityBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        Log.d(TAG, "onCreate")

        bindingClass.acceptNumberButton.setOnClickListener {
            val count = bindingClass.inputNumberField.getText().toString().toInt()
            if(count >= 1000) {
                val tempText = "красава у тебя $count подписчиков, но ты всё равно лох"
                bindingClass.textWhoAreYou.text = tempText //если 1000 и больше подпсоты
            }
            else if(count in 500..999) {
                val tempText = "ммм у тебя $count подписчиков, но ты всё равно лох"
                bindingClass.textWhoAreYou.text =  tempText//если 500 до 1000
            }
            else if(count in 100..499) {
                val tempText = "у тебя больше 100 подписчиков, целых $count но ты лох"
                bindingClass.textWhoAreYou.text =  tempText//от 100 и до 500
            }
            else if (count in 0..100) {
                val tempText = "у тебя до 100 подписчиков, вообще иди отсюда лох"
                bindingClass.textWhoAreYou.text =  tempText//до 100 подписоты
            } else {
                val tempText = "ВВЕДЕНЫ НЕВЕРНЫЕ ДАННЫЕ, ВВЕДИ ЧИСЛО"
                bindingClass.textWhoAreYou.text =  tempText//ошибка не отрабатывает
            }
        }

        bindingClass.buttonPreviousActivity.setOnClickListener {
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

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}