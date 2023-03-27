package com.example.myapplication2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import com.example.myapplication2.constance.Constance
import com.example.myapplication2.databinding.ActivitySalaryBinding

class SalaryActivity : AppCompatActivity() {

    private lateinit var bindingClass : ActivitySalaryBinding
    private val buttonsFunc = ButtonsFunc()
    var newUserLogin = ""
    var newUserPass = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySalaryBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

//        кнопка submit
        bindingClass.submitButton.setOnClickListener {
            bindingClass.resultTextView.visibility = View.VISIBLE
            bindingClass.resultTextView.setTextColor(Color.GREEN)
            when(bindingClass.nameEditText.text.toString()) {
                Constance.ADMIN_LOGIN -> buttonsFunc.accessCheck(bindingClass, Constance.ADMIN_LOGIN,Constance.ADMIN_PASS, Constance.ADMIN_HELLO)
                Constance.ROOT_LOGIN -> buttonsFunc.accessCheck(bindingClass, Constance.ROOT_LOGIN, Constance.ROOT_PASS, Constance.ROOT_HELLO)
                Constance.USER_LOGIN -> buttonsFunc.accessCheck(bindingClass, Constance.USER_LOGIN, Constance.USER_PASS, Constance.USER_HELLO)
                newUserLogin -> buttonsFunc.accessCheck(bindingClass, newUserLogin, newUserPass, Constance.NEW_USER_HELLO)
                else -> {
                    bindingClass.allowImageView.visibility = View.GONE
                    bindingClass.deniedImageView.visibility = View.VISIBLE
                    bindingClass.resultTextView.setTextColor(Color.parseColor("#F44336"))
                    bindingClass.resultTextView.text = "Неверный логин"
                }
            }
        }
//        кнопка регистрации
        bindingClass.registerButton.setOnClickListener {
            newUserLogin = bindingClass.nameEditText.text.toString()
            newUserPass = bindingClass.passwdEditText.text.toString()
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