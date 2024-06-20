package com.example.dtpckase.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dtpckase.R
import com.example.dtpckase.adapter.MenuAdapter
import com.example.dtpckase.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter : MenuAdapter
    private val originalMenuProductName = listOf("product01","product02","product03","producto04","product05","product06","product07","product08")

    private val originalMenuItemPrice = listOf("S/.120.00","S/.140.00","S/.150.00","S/.100.00","S/.200.00","S/.120.00","S/.140.00","S/.150.00")
    private val originalMenuImage = listOf(
        R.drawable.aasas,
        R.drawable.ccdsc,
        R.drawable.csc,
        R.drawable.dsdwd,
        R.drawable.dsadad,
        R.drawable.aasas,
        R.drawable.ccdsc,
        R.drawable.csc
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val filteredMenuProductName = mutableListOf<String>()
    private val filteredItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = MenuAdapter(filteredMenuProductName,filteredItemPrice,filteredMenuImage)
        binding.productRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.productRecyclerView.adapter = adapter

        //Setup para la vista search
        setupSearchView()
        showAllMenu()
    return binding.root
    }

    private fun showAllMenu() {
        filteredMenuProductName.clear()
        filteredItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuProductName.addAll(originalMenuProductName)
        filteredItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)
    }

    private fun setupSearchView(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }

        })

    }

    private fun filterMenuItems(query: String?) {
        filteredMenuProductName.clear()
        filteredItemPrice.clear()
        filteredMenuImage.clear()
        
        originalMenuProductName.forEachIndexed { index, productName ->
            if(productName.contains(query.toString(), ignoreCase = true)){
                filteredMenuProductName.add(productName)
                filteredItemPrice.add(originalMenuItemPrice[index])
                filteredMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()

    }

    companion object {

    }
}