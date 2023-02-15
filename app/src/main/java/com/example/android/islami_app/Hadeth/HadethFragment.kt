package com.example.android.islami_app.Hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.islami_app.Finals
import com.example.android.islami_app.databinding.FragmentHadethBinding
import com.example.android.islami_app.sura_detail_screen.HadethDetailActivity

class HadethFragment : Fragment() {

    lateinit var binding:FragmentHadethBinding

    lateinit var adapter: HadethAdapter

       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHadethBinding.inflate(inflater , container , false)
        return binding.root

       }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val hadethList = loadHadeth()


        adapter = HadethAdapter(hadethList)

        adapter.onClickListener = object : HadethAdapter.onHadethClickListener{

            override fun onSuraClick(content: String) {
                val intent = Intent(activity , HadethDetailActivity::class.java)
                intent.putExtra(Finals.HADETH_KEY , content )
                startActivity(intent)
            }
        }
        binding.rv.adapter = adapter

    }

    fun loadHadeth(): List<Hadeth> {

        val hadethList = ArrayList<Hadeth>()

        var content = activity?.assets?.open("ahadeth.txt")?.bufferedReader().use {
            it?.readText()
        }
        val allHadethContent: List<String> = content?.trim()?.split('#') ?: listOf()

        for (i in 0 until allHadethContent.size) {
            val singleHadeth = allHadethContent[i].trim()
            val indexOfFirstLine = singleHadeth.indexOf('\n')
            val title = singleHadeth.substring(0, indexOfFirstLine + 1)
            val singleContent = singleHadeth.substring(indexOfFirstLine + 1)
            val h = Hadeth(title, singleContent)
            hadethList.add(h)
        }

        return hadethList
    }

}