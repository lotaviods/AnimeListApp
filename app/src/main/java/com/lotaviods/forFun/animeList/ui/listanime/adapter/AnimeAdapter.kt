package com.lotaviods.forFun.animeList.ui.listanime.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lotaviods.forFun.animeList.R
import com.lotaviods.forFun.animeList.model.Anime
import com.lotaviods.forFun.animeList.ui.listanime.viewHolder.AnimeViewHolder

class AnimeAdapter(private val context: Context?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val animes: MutableList<Anime> = mutableListOf()

    fun loadAnimes(animes: List<Anime>?){
        this.animes.clear()

        animes?.let{
            this.animes.addAll(it)
        }

        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as AnimeViewHolder
        val anime = animes.elementAt(position)

        holder.bindView(anime)

    }

    override fun getItemCount(): Int {
        return animes.size
    }
}