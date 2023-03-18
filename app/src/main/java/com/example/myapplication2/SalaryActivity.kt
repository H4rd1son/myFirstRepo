package com.example.myapplication2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication2.constance.Constance
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
                Constance.ADMIN_LOGIN -> {
                    if(bindingClass.passwdEditText.text.toString() == Constance.ADMIN_PASS) {
                        bindingClass.resultTextView.text = Constance.ADMIN_HELLO
                            bindingClass.allowImageView.visibility = View.VISIBLE
                            bindingClass.deniedImageView.visibility = View.GONE
                    }
                    else {
                        bindingClass.allowImageView.visibility = View.GONE
                        bindingClass.deniedImageView.visibility = View.VISIBLE
                        bindingClass.resultTextView.setTextColor(Color.parseColor("#F44336"))
                        bindingClass.resultTextView.text = "Неверный логин или пароль"
                    }
                }
                Constance.ROOT_LOGIN -> {
                    if(bindingClass.passwdEditText.text.toString() == Constance.ROOT_PASS) {
                    bindingClass.resultTextView.text = Constance.ROOT_HELLO
                        bindingClass.allowImageView.visibility = View.VISIBLE
                        bindingClass.deniedImageView.visibility = View.GONE
                    }
                    else {
                        bindingClass.allowImageView.visibility = View.GONE
                        bindingClass.deniedImageView.visibility = View.VISIBLE
                        bindingClass.resultTextView.setTextColor(Color.parseColor("#F44336"))
                        bindingClass.resultTextView.text = "Неверный логин или пароль"
                    }
                }
                Constance.USER_LOGIN -> {
                    if(bindingClass.passwdEditText.text.toString() == Constance.USER_PASS) {
                    bindingClass.resultTextView.text = Constance.USER_HELLO
                        bindingClass.allowImageView.visibility = View.VISIBLE
                        bindingClass.deniedImageView.visibility = View.GONE
                    }
                    else {
                        bindingClass.allowImageView.visibility = View.GONE
                        bindingClass.deniedImageView.visibility = View.VISIBLE
                        bindingClass.resultTextView.setTextColor(Color.parseColor("#F44336"))
                        bindingClass.resultTextView.text = "Неверный логин или пароль"
                    }
                }
                else -> {
                    bindingClass.allowImageView.visibility = View.GONE
                    bindingClass.deniedImageView.visibility = View.VISIBLE
                    bindingClass.resultTextView.setTextColor(Color.parseColor("#F44336"))
                    bindingClass.resultTextView.text = "Неверный логин или пароль"
                }
            }
        }
    }
    fun accessCheck(login:String, pass:String, hello:String) {
        when (bindingClass.nameEditText.text.toString()) {
            login -> {
                if (bindingClass.passwdEditText.text.toString() == pass) {
                    bindingClass.resultTextView.text = hello
                    bindingClass.allowImageView.visibility = View.VISIBLE
                } else {
                    bindingClass.resultTextView.setTextColor(Color.parseColor("#F44336"))
                    bindingClass.resultTextView.text = "Неверный логин или пароль"
                }
            }
        }
    }
}