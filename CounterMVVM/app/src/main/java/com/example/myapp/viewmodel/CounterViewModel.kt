package com.example.myapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    val counter  = MutableLiveData<Int>()
    private var _counter = 0

    init{
        counter.value = _counter
    }

    fun incrementCounter (){
        counter.value  = (++_counter)
    }

    fun decrementCounter(){
        counter.value  = (--_counter)
    }

}

