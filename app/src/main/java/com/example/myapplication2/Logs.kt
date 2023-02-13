package com.example.myapplication2

import android.util.Log
import android.view.View

class Logs {
    fun button1Log(v: View) {
        Log.d("TAG", "Button1 was pressed")
    }
    fun button2Log(v : View) {
        Log.d("TAG", "Button2 was pressed")
    }
    fun button3Log(v: View){
        Log.d("TAG", "ButtonReset was pressed")
    }
}
//аргументом у обработчика событий является переменная типа View