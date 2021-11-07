package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motivation.R
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        mSecurityPreferences = SecurityPreferences(this)
        binding.textName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

        binding.buttonNewPhrase.setOnClickListener {
            handleNewPhrase()
        }

        binding.imageAll.setOnClickListener {
            binding.imageAll.setColorFilter(resources.getColor(R.color.colorPrimaryVariant))
            binding.imageHappy.setColorFilter(resources.getColor(R.color.white))
            binding.imageMorning.setColorFilter(resources.getColor(R.color.white))
        }

        binding.imageHappy.setOnClickListener {
            binding.imageHappy.setColorFilter(resources.getColor(R.color.colorPrimaryVariant))
            binding.imageAll.setColorFilter(resources.getColor(R.color.white))
            binding.imageMorning.setColorFilter(resources.getColor(R.color.white))
        }

        binding.imageMorning.setOnClickListener {
            binding.imageMorning.setColorFilter(resources.getColor(R.color.colorPrimaryVariant))
            binding.imageAll.setColorFilter(resources.getColor(R.color.white))
            binding.imageHappy.setColorFilter(resources.getColor(R.color.white))
        }
    }

    private fun handleNewPhrase() {

    }
}