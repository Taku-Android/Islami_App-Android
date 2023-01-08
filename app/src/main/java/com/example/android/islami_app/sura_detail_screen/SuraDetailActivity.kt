package com.example.android.islami_app.sura_detail_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.islami_app.Finals
import com.example.android.islami_app.Hadeth.HadethAdapter
import com.example.android.islami_app.databinding.SuraDetailContentBinding

class SuraDetailActivity : AppCompatActivity() {

    lateinit var adapter: SuraAdapter

    lateinit var binding: SuraDetailContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SuraDetailContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val index = intent.getIntExtra(Finals.SURA_KEY , 0)

        adapter = SuraAdapter(getSuraDetailList(index + 1))

        binding.includ.rvSura.adapter = adapter


        binding.back.setOnClickListener {
            finish()
        }

    }


    fun getSuraDetailList(index : Int): List<String> {
        val suras = this@SuraDetailActivity.assets.open("${index}.txt").bufferedReader().use {
            it.readText().split("\n")
        }
        return suras ;
    }

}