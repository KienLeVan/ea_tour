package com.cardes.eatournament.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cardes.eatournament.R
import com.cardes.eatournament.db.entity.Player

class PlayerAdapter : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    private val players = mutableListOf<Player>()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): PlayerViewHolder {
        return PlayerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.player_item_view, parent, false))
    }

    override fun getItemCount(): Int = players.size

    override fun onBindViewHolder(viewHolder: PlayerViewHolder, position: Int) {
        viewHolder.bind(players[position])
    }

    fun setPlayers(players: List<Player>) {
        this.players.clear()
        this.players.addAll(players)
        notifyDataSetChanged()
    }

    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerName = itemView.findViewById<TextView>(R.id.playerName)!!

        fun bind(player: Player) {
            playerName.text = player.name
        }
    }
}

