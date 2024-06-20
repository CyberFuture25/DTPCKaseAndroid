package com.example.dtpckase.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dtpckase.R
import com.example.dtpckase.adapter.CartAdapter
import com.example.dtpckase.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container, false)




        val cartProductName = listOf("product01","product02","product03","producto04","product05")
        val cartItemPrice = listOf("S/.120.00","S/.140.00","S/.150.00","S/.100.00","S/.200.00")
        val cartImage = listOf(
            R.drawable.aasas,
            R.drawable.ccdsc,
            R.drawable.csc,
            R.drawable.dsdwd,
            R.drawable.dsadad,
        )
        val adapter = CartAdapter(ArrayList(cartProductName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}