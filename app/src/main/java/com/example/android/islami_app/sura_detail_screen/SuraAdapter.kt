package com.example.android.islami_app.sura_detail_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.islami_app.databinding.SuraItemBinding

class SuraAdapter(val suraList: List<String>) : RecyclerView.Adapter<SuraAdapter.suraViewHolder>() {


    class suraViewHolder(val binding: SuraItemBinding) : RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): suraViewHolder {

        val bind = SuraItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false )

        return suraViewHolder(bind)

    }



    override fun onBindViewHolder(holder: suraViewHolder, position: Int) {

        val pos = suraList.get(position)


        with(holder){
            with(binding){
                suraName.text = pos

                if (position == suraList.size -1){
                    lineBreak.visibility = View.GONE
                }
            }
        }

}




    override fun getItemCount(): Int {
           return suraList.size
    }



}