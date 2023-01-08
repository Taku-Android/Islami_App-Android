package com.example.android.islami_app.radio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.islami_app.R
import com.example.android.islami_app.databinding.FragmentRadioBinding
import com.example.android.islami_app.databinding.FragmentSebhaBinding

class RadioFragment : Fragment() {

    lateinit var binding: FragmentRadioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRadioBinding.inflate(inflater , container , false)
        return binding.root

    }





}