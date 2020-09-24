package com.aslanovaslan.inlinechats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aslanovaslan.inlinechats.R
import com.aslanovaslan.inlinechats.databinding.PlayerItemBinding
import com.aslanovaslan.inlinechats.model.PlayerModel
import kotlinx.android.synthetic.main.player_item.view.*

class RecyclerViewAdapter(private val playerList: ArrayList<PlayerModel>) :
    RecyclerView.Adapter<RecyclerViewAdapter.PlayerViewHolder>() {
     class PlayerViewHolder(var view: PlayerItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = DataBindingUtil.inflate<PlayerItemBinding>(LayoutInflater.from(parent.context),R.layout.player_item, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
     holder.view.playerItem=playerList[position]
    /*    holder.itemView.instrumentName.text = playerList[position].instrumentName
        holder.itemView.imageViewInstrument.setImageResource(playerList[position].instrumentImage)
        holder.itemView.imageViewInsBack.setImageResource(playerList[position].instrumentBackgroundImage)
   */
    }

    override fun getItemCount(): Int {
        return playerList.size
    }
}