package com.example.android.islami_app.Sebha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.islami_app.R
import com.example.android.islami_app.databinding.FragmentQuranBinding
import com.example.android.islami_app.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {

    lateinit var binding: FragmentSebhaBinding

    var count = 0
    var tasbehCount = 0

    var tasbeh_list = listOf<String>(
        "سبحان الله",
        " الله اكبر",
        " الحمد لله",
        " لا الله الا الله",
        " استغفر الله"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSebhaBinding.inflate(inflater , container , false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tasbehName.text = tasbeh_list[tasbehCount]

        binding.tasbehCount.text = count.toString()


        binding.tasbehName.setOnClickListener {
            count++
            binding.tasbehCount.text = count.toString()

            if (count > 10){
                count = 0
                binding.tasbehCount.text = count.toString()

                tasbehCount++
                if(tasbehCount < tasbeh_list.size){
                    binding.tasbehName.text = tasbeh_list[tasbehCount]

                }else{
                    tasbehCount = 0
                }
            }



        }


    }

}