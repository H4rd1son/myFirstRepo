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
    private var newUserLogin: String = ""
    private var newUserPass: String = ""
    private var logins: Array<String> = arrayOf("admin", "user", "root")
    private var passwords: Array<String> = arrayOf("admin", "user", "root")

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
                logins[0] -> buttonsFunc.accessCheck(bindingClass, logins[0], passwords[0], "Login from array succsess")
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
}