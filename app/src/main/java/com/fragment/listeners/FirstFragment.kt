package com.fragment.listeners

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.fragment.listeners.databinding.FragmentFirstBinding

class FirstFragment(private val toolbarCallback: ToolbarCallback) :
    Fragment(R.layout.fragment_first) {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFirstBinding.bind(view)
        toggleToolbarVisibility()
        binding.btnToolbarToggle.setOnClickListener {
            toggleToolbarVisibility()
        }
    }

    private fun toggleToolbarVisibility() {
        if (toolbarCallback.toggleToolbarVisibility()) {
            binding.btnToolbarToggle.text = "Hide Toolbar"
            return
        }
        binding.btnToolbarToggle.text = "Show Toolbar"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}