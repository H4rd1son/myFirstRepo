package com.example.myapplication2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    val messageForActivity: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageForFrag1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageForFrag2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}