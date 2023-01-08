package com.example.android.islami_app.sura_detail_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.islami_app.Finals
import com.example.android.islami_app.Hadeth.HadethAdapter
import com.example.android.islami_app.databinding.ActivityHadethDetailBinding
import com.example.android.islami_app.databinding.HadethDetailContentBinding

class HadethDetailActivity : AppCompatActivity() {


    lateinit var binding: HadethDetailContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HadethDetailContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val content = intent.getStringExtra(Finals.HADETH_KEY)

        binding.includ.hadethTv.text = content

        binding.back.setOnClickListener {
            finish()
        }


    }




}