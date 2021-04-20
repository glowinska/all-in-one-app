package com.example.android.sleeptracker.aboutme

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.android.sleeptracker.databinding.FragmentAboutBindingBinding
import kotlinx.android.synthetic.main.fragment_about_me.*


class AboutBindingFragment : Fragment() {

    private lateinit var aboutBindingViewModel: AboutMeViewModel
    private var _binding: FragmentAboutBindingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBindingBinding.inflate(inflater, container, false)
        val view = binding.root
        aboutBindingViewModel =
                ViewModelProviders.of(this).get(AboutMeViewModel::class.java)
        binding.apply {
            doneButton.setOnClickListener {
                addNickname()
            }
            nicknameText.setOnClickListener {
                updateNickname()
            }
        }
        return view
    }

    private fun addNickname() {
        binding.apply {
            nicknameText.text = nicknameEdit.text
            nicknameText.visibility = View.VISIBLE
            doneButton.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
        }
        // Hide the keyboard.
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireView().windowToken, 0)
    }

    private fun updateNickname() {
        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
            nicknameEdit.requestFocus()
        }
        // Show the keyboard.
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(nickname_edit, 0)
    }
}