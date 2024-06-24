package com.example.dtpckase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dtpckase.adapter.MenuAdapter

import com.example.dtpckase.databinding.FragmentProductBootomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ProductBootomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentProductBootomSheetBinding

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
        val menuProductName = listOf("product01","product02","product03","producto04","product05","product06","product07","product08")
         val menuItemPrice = listOf("S/.120.00","S/.140.00","S/.150.00","S/.100.00","S/.200.00","S/.120.00","S/.140.00","S/.150.00")
        val menuImage = listOf(
            R.drawable.aasas,
            R.drawable.ccdsc,
            R.drawable.csc,
            R.drawable.dsdwd,
            R.drawable.dsadad,
            R.drawable.aasas,
            R.drawable.ccdsc,
            R.drawable.csc
        )
        val adapter = MenuAdapter(
            ArrayList(menuProductName),
            ArrayList(menuItemPrice),
            ArrayList(menuImage),requireContext()

        )
        binding.productRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.productRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {
    }
}