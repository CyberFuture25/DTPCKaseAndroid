package com.examples.dtpckase

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dtpckase.databinding.FragmentProductBootomSheetBinding
import com.examples.dtpckase.adapter.MenuAdapter
import com.examples.dtpckase.model.MenuItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ProductBootomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentProductBootomSheetBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var menuItems: MutableList<MenuItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBootomSheetBinding.inflate(inflater, container, false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }
        retrieveMenuItems()


        return binding.root
    }

    private fun retrieveMenuItems() {
        database = FirebaseDatabase.getInstance()
        val productRef: DatabaseReference = database.reference.child("all products")
        menuItems = mutableListOf()

        productRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for(productSnapshot in snapshot.children){
                    val menuItem = productSnapshot.getValue(MenuItem::class.java)
                    menuItem?.let { menuItems.add(it)}

                }
                Log.d("ITEMS", "onDataChange: Data Received ")
                //once data receive , set to adapter
                setAdapter()

            }


            override fun onCancelled(error: DatabaseError) {

            }
        })

    }

    private fun setAdapter() {
        if(menuItems.isNotEmpty()) {
            val adapter = MenuAdapter(menuItems, requireContext())
            binding.productRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.productRecyclerView.adapter = adapter
            Log.d("ITEMS", "setAdapter: data set")
        }else {
            Log.d("ITEMS", "setAdapter: data NOT set")


        }
    }

    companion object {
    }

}