package com.example.android.sleeptracker.color

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android.sleeptracker.R
import com.example.android.sleeptracker.color.ColorViewModel

class ColorFragment : Fragment() {

    private lateinit var colorViewModel: ColorViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        colorViewModel =
                ViewModelProviders.of(this).get(ColorViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_color, container, false)
        val textView: TextView = root.findViewById(R.id.text_color)
        colorViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}