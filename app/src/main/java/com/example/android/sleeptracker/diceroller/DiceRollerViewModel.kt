package com.example.android.sleeptracker.diceroller

import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.sleeptracker.R

class DiceRollerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Dice Roller Fragment"
    }
    val text: LiveData<String> = _text


}