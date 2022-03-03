package com.kindred.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kindred.R
import com.kindred.databinding.AdapterGameslistBinding
import com.kindred.model.Games
import com.kindred.model.WishesV94mg
import com.squareup.picasso.Picasso

class GamesListAdapter: RecyclerView.Adapter<GamesListAdapter.MainViewHolder>() {

    private var context: Context?= null
    private var games: Map<String, WishesV94mg> =  mapOf<String, WishesV94mg>()
    private var list: List<WishesV94mg>?= null

    fun addData(response: Games) {
        this.games = response.games
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterGameslistBinding.inflate(inflater, parent, false)
        context = parent.context
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val games = games
        list = ArrayList(games.values)

        if (list != null){
            val gameModel = list!![position]
            holder.binding.tvGameName.text = gameModel.gameName
            Picasso.get()
                .load(gameModel.backgroundImageUrl)
                .fit()
                .placeholder(R.drawable.progress_animation)
                .into(holder.binding.backgroundImage);
        }
    }

    override fun getItemCount(): Int {
        return games!!.size
    }

    class MainViewHolder(val binding: AdapterGameslistBinding) : RecyclerView.ViewHolder(binding.root) {}
}