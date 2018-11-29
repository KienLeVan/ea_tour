package com.cardes.eatournament.view

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.cardes.eatournament.R
import com.cardes.eatournament.db.entity.Team

class TeamAdapter(private val teamClickListener: TeamClickListener) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    private val teams = mutableListOf<Team>()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): TeamViewHolder {
        return TeamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.team_item_view, parent, false))
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(viewHolder: TeamViewHolder, position: Int) {
        viewHolder.bind(teams[position])
    }

    fun setData(teams: List<Team>) {
        this.teams.clear()
        this.teams.addAll(teams)
        notifyDataSetChanged()
    }

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val teamName = itemView.findViewById<TextView>(R.id.teamName)!!
        private val teamCard = itemView.findViewById<CardView>(R.id.teamCard)!!

        fun bind(team: Team) {
            teamName.text = team.name
            teamCard.setOnClickListener {
                teamClickListener.onTeamClick(team)
            }
        }
    }

    interface TeamClickListener {
        fun onTeamClick(team: Team)
    }
}