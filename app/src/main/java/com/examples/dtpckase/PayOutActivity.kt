package com.examples.dtpckase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dtpckase.databinding.ActivityPayOutBinding

class PayOutActivity : AppCompatActivity() {
    lateinit var binding : ActivityPayOutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.PlaceMyOrder.setOnClickListener {
    val bottomSheetDialog = CongratsBottomSheet()
        bottomSheetDialog.show(supportFragmentManager, "Test")
        }
    }
}