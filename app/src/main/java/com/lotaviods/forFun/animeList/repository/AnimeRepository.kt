package com.lotaviods.forFun.animeList.repository

import com.lotaviods.forFun.animeList.model.AnimeHttp
import com.lotaviods.forFun.animeList.model.InfoRequest

class AnimeRepository {
    fun getAnimes(): InfoRequest? {
        return AnimeHttp.searchAnimes()
    }
    fun postaAnime(nome: String): Boolean? {
        return AnimeHttp.postaAnime(nome = nome)
    }
}