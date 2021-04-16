package com.example.android.sleeptracker.color

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is color Fragment"
    }
    val text: LiveData<String> = _text
}