package com.example.android.islami_app.Quran

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.islami_app.R
import com.example.android.islami_app.databinding.SuraItemBinding
import kotlinx.coroutines.withContext

class QuranAdapter(val suraList: List<String>) : RecyclerView.Adapter<QuranAdapter.suraViewHolder>() {


    class suraViewHolder(val binding: SuraItemBinding) : RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): suraViewHolder {

        val bind = SuraItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false )

        return suraViewHolder(bind)

    }


    interface onSuraClickListener{
        fun onSuraClick(pos:Int)
    }
    var onClickListener : onSuraClickListener? = null

    override fun onBindViewHolder(holder: suraViewHolder, position: Int) {

        val pos = suraList.get(position)


        with(holder){
            with(binding){
                suraName.text = pos
                suraName.setOnClickListener{
                    onClickListener?.onSuraClick(position)
                }

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