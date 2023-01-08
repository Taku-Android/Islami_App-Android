package com.example.android.islami_app.Hadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.islami_app.databinding.SuraItemBinding

class HadethAdapter(val suraList: List<Hadeth>) : RecyclerView.Adapter<HadethAdapter.hadethViewHolder>() {


    class hadethViewHolder(val binding: SuraItemBinding) : RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hadethViewHolder {

        val bind = SuraItemBinding.inflate(LayoutInflater.from(parent.context) , parent , false )

        return hadethViewHolder(bind)

    }


    interface onHadethClickListener{
        fun onSuraClick(content: String)
    }
    var onClickListener : onHadethClickListener? = null


    override fun onBindViewHolder(holder: hadethViewHolder, position: Int) {

        val pos = suraList.get(position)


        with(holder){
            with(binding){
                suraName.text = pos.name
                suraName.setOnClickListener{
                    onClickListener?.onSuraClick(pos.content)
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