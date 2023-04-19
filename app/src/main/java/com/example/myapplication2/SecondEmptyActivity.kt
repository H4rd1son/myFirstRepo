package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Second Activity"
        Log.d(TAG, "onCreate")
//        val count = bindingClass.inputNumberField.getText().toString()

        bindingClass.acceptNumberButton.setOnClickListener {
            val count = bindingClass.inputNumberField.getText().toString()
            if (count == "") {
            val tempText = "ВВЕДЕНЫ НЕВЕРНЫЕ ДАННЫЕ, ВВЕДИ ЧИСЛО"
            bindingClass.textWhoAreYou.text =  tempText //validate string
            }
            else if(count.toInt() >= 1000) {
                val tempText = "красава у тебя $count подписчиков, но ты всё равно лох"
                bindingClass.textWhoAreYou.text = tempText //если 1000 и больше подпсоты
                supportActionBar?.title = "Подписоты: $count"
            }
            else if(count.toInt() in 500..999) {
                val tempText = "ммм у тебя $count подписчиков, но ты всё равно лох"
                bindingClass.textWhoAreYou.text =  tempText//если 500 до 1000
                supportActionBar?.title = "Подписоты: $count"
            }
            else if(count.toInt() in 100..499) {
                val tempText = "у тебя больше 100 подписчиков, целых $count но ты лох"
                bindingClass.textWhoAreYou.text =  tempText//от 100 и до 500
                supportActionBar?.title = "Подписоты: $count"
            }
            else if (count.toInt() in 0..100) {
                val tempText = "у тебя до 100 подписчиков, вообще иди отсюда лох"
                bindingClass.textWhoAreYou.text =  tempText//до 100 подписоты
                supportActionBar?.title = "Подписоты: $count"
            }
            else {
                val tempText = "ВВЕДЕНЫ НЕВЕРНЫЕ ДАННЫЕ, ВВЕДИ ЧИСЛО"
                bindingClass.textWhoAreYou.text =  tempText//ошибка не отрабатывает
                supportActionBar?.title = "ОШИБКА"
            }
        }

        bindingClass.buttonPreviousActivity.setOnClickListener {
            val count = bindingClass.inputNumberField.getText().toString()
            val intent = Intent(this@SecondEmptyActivity, MainActivity::class.java)
            intent.putExtra("count", count)
            setResult(RESULT_OK, intent)
            finish()
//            startActivity(intent)
        }
        bindingClass.buttonThirdScreen.setOnClickListener {
            val intent = Intent(this@SecondEmptyActivity, SalaryActivity::class.java)
            startActivity(intent)
        }
    }

    //    функция которая загружает меню из разметки main_menu, она есть у активити
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu) //наполняем разметку меню с помощью menuInflater, указываем куда мы хотим поместить
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
            R.id.sync -> {
                Toast.makeText(this, "Sync", Toast.LENGTH_SHORT).show()
            }
            R.id.search -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
            R.id.save -> {
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
            }
        }
        return true
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