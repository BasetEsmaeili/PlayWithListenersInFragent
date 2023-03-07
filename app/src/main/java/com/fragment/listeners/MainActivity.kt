package com.fragment.listeners

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.fragment.listeners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ToolbarCallback {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, FirstFragment(this))
            .commit()
    }

    override fun toggleToolbarVisibility(): Boolean {
        val isVisible = binding.toolbar.isVisible.not()
        binding.toolbar.isVisible = isVisible
        return isVisible
    }
}