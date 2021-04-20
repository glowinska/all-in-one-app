package com.example.android.sleeptracker.aboutme

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.android.sleeptracker.R
import com.example.android.sleeptracker.databinding.FragmentAboutBindingBinding
import kotlinx.android.synthetic.main.fragment_about_me.*


class AboutBindingFragment : Fragment() {

    // private lateinit var aboutBindingViewModel: AboutMeViewModel
    private var _binding: FragmentAboutBindingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBindingBinding.inflate(inflater, container, false)
        val view = binding.root
//        aboutBindingViewModel =
//                ViewModelProviders.of(this).get(AboutMeViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_about_binding, container, false)
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }
        return view
    }

    private fun addNickname(viewThatIsClicked: View) {
        binding.nicknameText.text = binding.nicknameEdit.text
        binding.nicknameText.visibility = View.VISIBLE
        viewThatIsClicked.visibility = View.GONE
        binding.nicknameEdit.visibility = View.GONE
        // Hide the keyboard.
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(requireView().windowToken, 0)
    }

    private fun updateNickname(view: View) {
        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        binding.nicknameEdit.requestFocus()
        // Show the keyboard.
        val inputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(nickname_edit, 0)
    }
}