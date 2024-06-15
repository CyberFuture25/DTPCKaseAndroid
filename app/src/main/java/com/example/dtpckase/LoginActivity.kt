package com.example.dtpckase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dtpckase.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding:ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.loginbutton.setOnClickListener {
            val intent = Intent(this,SignActivity::class.java)
            startActivity(intent)
        }
        binding.notienescuentatxt.setOnClickListener {
            val intent=Intent(this,SignActivity::class.java)
            startActivity(intent)
        }

        }
    }
