package com.example.myapplication2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.myapplication2.constance.Constance
import com.example.myapplication2.databinding.ActivitySalaryBinding

class SalaryActivity : AppCompatActivity() {

    private lateinit var bindingClass : ActivitySalaryBinding
    private val buttonsFunc = ButtonsFunc()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySalaryBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.submitButton.setOnClickListener {
            bindingClass.resultTextView.visibility = View.VISIBLE
            bindingClass.resultTextView.setTextColor(Color.GREEN)
            when(bindingClass.nameEditText.text.toString()) {
                Constance.ADMIN_LOGIN -> accessCheckIf(Constance.ADMIN_LOGIN,Constance.ADMIN_PASS, Constance.ADMIN_HELLO)
                Constance.ROOT_LOGIN -> accessCheckIf(Constance.ROOT_LOGIN, Constance.ROOT_PASS, Constance.ROOT_HELLO)
                Constance.USER_LOGIN -> accessCheckIf(Constance.USER_LOGIN, Constance.USER_PASS, Constance.USER_HELLO)
                else -> {
                    bindingClass.allowImageView.visibility = View.GONE
                    bindingClass.deniedImageView.visibility = View.VISIBLE
                    bindingClass.resultTextView.setTextColor(Color.parseColor("#F44336"))
                    bindingClass.resultTextView.text = "Неверный логин"
                }
            }
        }
    }
    private fun accessCheckIf(login:String, pass:String, hello:String) {
        if (bindingClass.nameEditText.text.toString() == login) {
                if (bindingClass.passwdEditText.text.toString() == pass) {
                    bindingClass.resultTextView.text = hello
                    bindingClass.allowImageView.visibility = View.VISIBLE
                    bindingClass.deniedImageView.visibility = View.GONE
                }
                else {
//                    bindingClass.allowImageView.setImageResource(R.drawable.access_denied)
                    bindingClass.allowImageView.visibility = View.GONE
                    bindingClass.deniedImageView.visibility = View.VISIBLE
                    bindingClass.resultTextView.setTextColor(Color.parseColor("#F44336"))
                    bindingClass.resultTextView.text = "Неверный пароль"
                }
        } else {
            bindingClass.allowImageView.visibility = View.GONE
            bindingClass.deniedImageView.visibility = View.VISIBLE
            bindingClass.resultTextView.setTextColor(Color.parseColor("#F44336"))
            bindingClass.resultTextView.text = "Неверный логин"
        }
    }
}