package com.examples.dtpckase

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.dtpckase.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailsBinding
    private var productName: String? = null
    private var productCategory: String? = null
    private var productPrice: String? = null
    private var productImage: String? = null
    private var productDescription: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productName = intent.getStringExtra("MenuItemName")
        productCategory = intent.getStringExtra("MenuItemCategory")
        productPrice = intent.getStringExtra("MenuItemPrice")
        productImage = intent.getStringExtra("MenuItemImage")
        productDescription = intent.getStringExtra("MenuItemDescription")

        with(binding){
            detailProductName.text = productName
            detailCategory.text =  productCategory
            detailDescription.text = productDescription
            Glide.with(this@DetailsActivity).load(Uri.parse(productImage)).into(detailProductImage)





        }


        binding.imageButton.setOnClickListener {
            finish()
        }
        }
    }
