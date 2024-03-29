package com.example.myapplication2


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.example.myapplication2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var getContent : ActivityResultLauncher<Intent>? = null
    var count:Int=0
    private val funcLogs = Logs()
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)

        setContentView(bindingClass.root)

        getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
            if(result.resultCode == RESULT_OK){
                val text = result.data?.getStringExtra("count")
                bindingClass.textViewYouText.text = text
            }
        }

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
            getContent?.launch(Intent(this@MainActivity, SecondEmptyActivity::class.java))
        }

        //      кнопка перехода на второе активити используя intent
        bindingClass.buttonArrayActivity.setOnClickListener {
            val intent = Intent(this@MainActivity, ArrayActivity::class.java)
            startActivity(intent)
        }
/*      если нужно сменить первый выбранный элемент на другой
        bindingClass.bNav.selectedItemId = R.id.third_screen*/
        bindingClass.bNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.second_screen -> {
                    getContent?.launch(Intent(this@MainActivity, SecondEmptyActivity::class.java))
                }
                R.id.third_screen -> {
                    getContent?.launch(Intent(this@MainActivity, SalaryActivity::class.java))
                }
                R.id.four_screen -> {
                    getContent?.launch(Intent(this@MainActivity, BottomNavigationViewActiivity::class.java))
                }
                R.id.five_screen -> {
                    getContent?.launch(Intent(this@MainActivity, Fragment::class.java))
                }
            }
            true
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_item_menu, menu) //наполняем разметку меню с помощью menuInflater, указываем куда мы хотим поместить
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.second_screen -> {
                getContent?.launch(Intent(this@MainActivity, SecondEmptyActivity::class.java))
            }
            R.id.third_screen -> {
                getContent?.launch(Intent(this@MainActivity, SalaryActivity::class.java))
            }
            R.id.four_screen -> {
                getContent?.launch(Intent(this@MainActivity, BottomNavigationViewActiivity::class.java))
            }
            R.id.five_screen -> {
                getContent?.launch(Intent(this@MainActivity, Fragment::class.java))
            }
        }
        return true
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1 && data != null){
            bindingClass.textViewYouText.text = data.getStringExtra("count")
        }
    }*/
}