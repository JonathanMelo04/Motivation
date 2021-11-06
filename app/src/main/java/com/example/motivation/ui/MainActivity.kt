package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        mSecurityPreferences = SecurityPreferences(this)
        binding.textName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
    }
}