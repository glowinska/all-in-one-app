package com.example.android.sleeptracker.color

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android.sleeptracker.R
import kotlinx.android.synthetic.main.fragment_color.*

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
        val boxOneText = root.findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = root.findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = root.findViewById<TextView>(R.id.box_three_text)
        val boxFourText = root.findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = root.findViewById<TextView>(R.id.box_five_text)
        val rootConstraintLayout = root.findViewById<View>(R.id.constraint_layout)
        val redButton = root.findViewById<Button>(R.id.red_button)
        val greenButton = root.findViewById<Button>(R.id.green_button)
        val yellowButton = root.findViewById<Button>(R.id.yellow_button)
        val clickableViews: List<View> =
                listOf(boxOneText, boxTwoText, boxThreeText,
                        boxFourText, boxFiveText, rootConstraintLayout, redButton, greenButton, yellowButton)
        setListeners(clickableViews)
        return root
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)
            R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners(clickableViews : List<View>) {
        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

}