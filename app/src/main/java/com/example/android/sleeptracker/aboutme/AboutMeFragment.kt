package com.example.android.sleeptracker.aboutme

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.android.sleeptracker.R
import kotlinx.android.synthetic.main.fragment_about_me.*


class AboutMeFragment : Fragment() {

    private lateinit var aboutMeViewModel: AboutMeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        aboutMeViewModel =
                ViewModelProviders.of(this).get(AboutMeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_about_me, container, false)
        root.findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }
        root.findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
        return root
    }

    private fun addNickname(viewThatIsClicked: View) {
        nickname_text.text = nickname_edit.text
        nickname_text.visibility = View.VISIBLE
        viewThatIsClicked.visibility = View.GONE
        nickname_edit.visibility = View.GONE
        // Hide the keyboard.
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireView().windowToken, 0)
    }

    private fun updateNickname(view: View) {
        nickname_edit.visibility = View.VISIBLE
        done_button.visibility = View.VISIBLE
        view.visibility = View.GONE
        nickname_edit.requestFocus()
        // Show the keyboard.
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(nickname_edit, 0)
    }
}