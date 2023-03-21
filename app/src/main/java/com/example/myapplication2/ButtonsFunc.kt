package com.example.myapplication2

import android.graphics.Color
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication2.databinding.ActivitySalaryBinding


class ButtonsFunc : AppCompatActivity() {

    fun accessCheck(login:String, pass:String, hello:String) {
        lateinit var bindingClass : ActivitySalaryBinding
        when (bindingClass.nameEditText.text.toString()) {
            login -> {
                if (bindingClass.passwdEditText.text.toString() == pass) {
                    bindingClass.resultTextView.text = hello
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
        }
    }
}