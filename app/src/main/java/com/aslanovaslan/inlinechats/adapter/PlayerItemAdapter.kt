package com.aslanovaslan.inlinechats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aslanovaslan.inlinechats.R
import com.aslanovaslan.inlinechats.databinding.PlayerCardItemBinding
import com.aslanovaslan.inlinechats.model.PlayerCardModel

class PlayerItemAdapter(var playerList: List<PlayerCardModel>) : RecyclerView.Adapter<PlayerItemAdapter.PlayerViewHolder>() {

    class PlayerViewHolder(var view: PlayerCardItemBinding) : RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view:PlayerCardItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.player_card_item,parent,false)

        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.view.varPlayerCard=playerList[position]
    }

    override fun getItemCount()= playerList.size


}