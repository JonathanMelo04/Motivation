package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motivation.R
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.repository.Mock

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        mSecurityPreferences = SecurityPreferences(this)
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        binding.textName.text = "Olá, $name!"

        binding.imageAll.setColorFilter(resources.getColor(R.color.colorPrimaryVariant))
        handleNewPhrase()

        binding.buttonNewPhrase.setOnClickListener {
            handleNewPhrase()
        }

        binding.imageAll.setOnClickListener {
            binding.imageAll.setColorFilter(resources.getColor(R.color.colorPrimaryVariant))
            binding.imageHappy.setColorFilter(resources.getColor(R.color.white))
            binding.imageMorning.setColorFilter(resources.getColor(R.color.white))
            mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL
        }

        binding.imageHappy.setOnClickListener {
            binding.imageHappy.setColorFilter(resources.getColor(R.color.colorPrimaryVariant))
            binding.imageAll.setColorFilter(resources.getColor(R.color.white))
            binding.imageMorning.setColorFilter(resources.getColor(R.color.white))
            mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
        }

        binding.imageMorning.setOnClickListener {
            binding.imageMorning.setColorFilter(resources.getColor(R.color.colorPrimaryVariant))
            binding.imageAll.setColorFilter(resources.getColor(R.color.white))
            binding.imageHappy.setColorFilter(resources.getColor(R.color.white))
            mPhraseFilter = MotivationConstants.PHRASEFILTER.MORNING
        }
    }

    private fun handleNewPhrase() {
        binding.textPhrase.text = Mock().getPhrase(mPhraseFilter)
    }
}