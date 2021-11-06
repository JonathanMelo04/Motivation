package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.motivation.databinding.ActivitySplashBinding
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        mSecurityPreferences = SecurityPreferences(this)

        binding.buttonSave.setOnClickListener {
            handleSave()
        }
    }

    private fun handleSave() {

        val name = binding.editName.text.toString()

        if(name != ""){
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            Toast.makeText(this,"Informe o seu nome!",Toast.LENGTH_SHORT).show()
        }
    }
}