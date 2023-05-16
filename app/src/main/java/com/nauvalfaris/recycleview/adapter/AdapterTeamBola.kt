package com.nauvalfaris.recycleview.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nauvalfaris.recyclerviewapp.model.Pemain
import com.nauvalfaris.recycleview.databinding.LiatItemPemainBinding

class AdapterTeamBola(private val context : Context,
                      private var data : List<Pemain>?,
                      private val itemClick : OnClickListener
) : RecyclerView.Adapter<AdapterTeamBola.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = LiatItemPemainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama
        holder.itemView.setOnClickListener {
            itemClick.detailData(item)
        }
    }

    inner class ViewHolder(val binding: LiatItemPemainBinding): RecyclerView.ViewHolder(binding.root){
        var foto = binding.image
        var nama = binding.txtnama
    }
    interface OnClickListener {
        fun detailData(item: Pemain?)
    }


}