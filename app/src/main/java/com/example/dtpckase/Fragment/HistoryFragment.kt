package com.example.dtpckase.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dtpckase.R
import com.example.dtpckase.adapter.BuyAgainAdapter
import com.example.dtpckase.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        setupRecyclerView()
        return binding.root
    }
    private fun setupRecyclerView(){
        val buyAgainProductName = arrayListOf("Product 2", "Product 3", "Product 4")
        val buyAgainProductPrice = arrayListOf("S/.120.00", "S/.140.00", "S/.150.00")
        val buyAgainProductImage = arrayListOf(R.drawable.dsdwd, R.drawable.dsadad,R.drawable.aasas)
        buyAgainAdapter = BuyAgainAdapter(buyAgainProductName,buyAgainProductPrice,buyAgainProductImage)
        binding.buyAgainRecyclerView.adapter = buyAgainAdapter
        binding.buyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    companion object {

    }
}