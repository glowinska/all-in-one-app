package com.example.android.sleeptracker.diceroller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android.sleeptracker.MainActivity
import com.example.android.sleeptracker.R
import kotlinx.android.synthetic.main.fragment_dice_roller.*
import kotlinx.android.synthetic.main.nav_header_main.*


class DiceRollerFragment : Fragment() {

    private lateinit var diceRollerViewModel: DiceRollerViewModel
    lateinit var diceImage : ImageView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        diceRollerViewModel =
                ViewModelProviders.of(this).get(DiceRollerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dice_roller, container, false)
        val textView: TextView = root.findViewById(R.id.text_dice_roller)
        diceRollerViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        diceImage = root.findViewById(R.id.dice_image)
        val rollButton: Button = root.findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        return root
    }

    private fun rollDice() {
        Toast.makeText(getActivity(), "Dice rolled", Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()
        result_text.text = randomInt.toString()
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
}