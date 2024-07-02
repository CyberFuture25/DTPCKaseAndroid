package com.examples.dtpckase.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dtpckase.databinding.MenuItemBinding
import com.examples.dtpckase.DetailsActivity
import com.examples.dtpckase.model.MenuItem

class MenuAdapter(
    private val menuItems:List<MenuItem>,
                  private val requireContext: Context
) :RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MenuViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position) 
    }
    override fun getItemCount(): Int = menuItems.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION){
                    openDetailsActivity(position)

                }

                // setonclick listener to open details
            }
        }

        private fun openDetailsActivity(position: Int) {
          val menuItem = menuItems[position]

            // a intent to open details activity and pass data
            val intent = Intent(requireContext, DetailsActivity::class.java).apply {
                putExtra("MenuItemName", menuItem.productName)
                putExtra("MenuItemCategory", menuItem.productCategory)
                putExtra("MenuItemPrice", menuItem.productPrice)
                putExtra("MenuItemImage", menuItem.productImage)
                putExtra("MenuItemDescription", menuItem.productDescription)
            }
            // start the details activity
            requireContext.startActivity(intent)
        }

        //set data in to recyclerview items name, price, image, etc
        fun bind(position: Int) {
            val menuItem = menuItems[position]
            binding.apply {
                productName.text=menuItem.productName
                menuPrice.text = menuItem.productPrice
                val uri = Uri.parse(menuItem.productImage)
                Glide.with(requireContext).load(uri).into(menuImage)



            }

        }

    }
    interface OnClickListener{
        fun onItemClick(position: Int)

    }

}

