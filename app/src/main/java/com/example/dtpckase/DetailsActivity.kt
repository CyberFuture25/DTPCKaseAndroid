package com.example.dtpckase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dtpckase.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding :ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)

         val productName = intent.getStringExtra("ProductItemName")
        val menuImage  = intent.getIntExtra("ProductItemImage", 0)
        binding.detailProductName.text = productName
        binding.DetailProductImage.setImageResource(menuImage)

        binding.imageButton.setOnClickListener {
            finish()
        }
        }
    }
