package com.lotaviods.forFun.animeList.ui.listanime.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lotaviods.forFun.animeList.model.Anime
import kotlinx.android.synthetic.main.list_item_anime.view.*


class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view){
    fun bindView(anime: Anime) {
        itemView.name_textViewField.text = anime.name
        itemView.description_textView.text = anime.description
        itemView.id_textView.text = "${absoluteAdapterPosition+1}"
    }
}