package com.example.dtpckase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dtpckase.adapter.NotificationAdapter
import com.example.dtpckase.databinding.FragmentNotifactionBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Notifaction_Bottom_Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotifactionBottomBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotifactionBottomBinding.inflate(layoutInflater,container,false )
        val notifications = listOf("Tu orden ha sido cancelada exitosamente","Orden ha sido recibida por el delivery","Orden realizada")
        val notificationImages = listOf(R.drawable.sademoji,R.drawable.truckicon,R.drawable.okicon)
        val adapter = NotificationAdapter(
            ArrayList(notifications),
            ArrayList(notificationImages)
        )

binding.notificationRecyclerView.layoutManager =  LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}