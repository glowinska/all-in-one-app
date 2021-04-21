package com.example.android.sleeptracker.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.sleeptracker.R
import com.example.android.sleeptracker.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMain2Binding>(this, R.layout.activity_main2)
    }

    // TODO (01) Create the new TitleFragment
    // Select File->New->Fragment->Fragment (Blank)

    // TODO (02) Clean up the new TitleFragment
    // In our new TitleFragment

    // TODO (03) Use DataBindingUtil.inflate to inflate and return the titleFragment in onCreateView
    // In our new TitleFragment
    // R.layout.fragment_title
}
