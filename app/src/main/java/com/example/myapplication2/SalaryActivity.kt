package com.example.myapplication2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication2.databinding.ActivitySalaryBinding

class SalaryActivity : AppCompatActivity() {

    lateinit var bindingClass : ActivitySalaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySalaryBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.submitButton.setOnClickListener {
            bindingClass.resultTextView.visibility = View.VISIBLE
            bindingClass.resultTextView.setTextColor(Color.GREEN)
            when(bindingClass.nameEditText.text.toString()) {
                "Admin" -> bindingClass.resultTextView.setText(Constance.ADMIN_LOGIN)
                "root" -> bindingClass.resultTextView.setText(Constance.ROOT_LOGIN)
                "user" -> bindingClass.resultTextView.setText(Constance.USER_LOGIN)
                else -> {
                    bindingClass.resultTextView.setTextColor(Color.parseColor("#F44336"))
                    bindingClass.resultTextView.setText("Неверный логин или пароль")
                }
            }
        }
    }
    object Constance{
        const val ADMIN_LOGIN = "Успешный логин. Приветсвую Admin"
        const val ROOT_LOGIN = "Успешный логин. Приветсвую ROOT"
        const val USER_LOGIN = "Успешный логин. Приветсвую User"
    }
}