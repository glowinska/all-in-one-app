package com.example.android.sleeptracker.diceroller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiceRollerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Dice Roller Fragment"
    }
    val text: LiveData<String> = _text
}