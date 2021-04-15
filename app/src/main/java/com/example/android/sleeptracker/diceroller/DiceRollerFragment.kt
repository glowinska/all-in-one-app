package com.example.android.sleeptracker.diceroller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android.sleeptracker.R


class DiceRollerFragment : Fragment() {

    private lateinit var diceRollerViewModel: DiceRollerViewModel

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
        return root
    }
}