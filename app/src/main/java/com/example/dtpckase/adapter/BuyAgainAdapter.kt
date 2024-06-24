package com.example.dtpckase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dtpckase.databinding.BuyAgainItemBinding

class BuyAgainAdapter(private val buyAgainProductName:ArrayList<String>,
                      private val buyAgainProductPrice:ArrayList<String>,
                      private val buyAgainProductImage:ArrayList<Int>) : RecyclerView
                          .Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
    holder.bind(buyAgainProductName[position],buyAgainProductPrice[position],buyAgainProductImage[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyAgainViewHolder(binding)
    }

    override fun getItemCount(): Int = buyAgainProductName.size
    class BuyAgainViewHolder(private val binding: BuyAgainItemBinding) : RecyclerView.ViewHolder
        (binding.root  ) {
        fun bind(productName: String, productPrice: String, productImage: Int) {
            binding.buyAgainProductName.text=productName
            binding.buyAgainProductPrice.text=productPrice
            binding.buyAgainProductImage.setImageResource(productImage)

        }

    }

} 