package com.lotaviods.forFun.animeList.ui.mainactivity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lotaviods.forFun.animeList.R
import com.lotaviods.forFun.animeList.model.Anime
import com.lotaviods.forFun.animeList.ui.mainactivity.viewHolder.AnimeViewHolder

class AnimeAdapter(private val context: Context?, private val Anime: List<Anime>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as AnimeViewHolder
        val anime = Anime.elementAt(position)

        holder.bindView(anime)

    }

    override fun getItemCount(): Int {
        return Anime.size
    }
}