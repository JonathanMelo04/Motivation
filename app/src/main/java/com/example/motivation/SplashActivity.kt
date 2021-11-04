package com.example.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.motivation.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.buttonSave.setOnClickListener {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = binding.editName.text.toString()

        if(name != ""){
            startActivity(Intent(this, MainActivity::class.java))
        }else{
            Toast.makeText(this,"Informe o seu nome!",Toast.LENGTH_SHORT).show()
        }
    }
}