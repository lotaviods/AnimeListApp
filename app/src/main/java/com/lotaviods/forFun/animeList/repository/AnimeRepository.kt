package com.lotaviods.forFun.animeList.repository

import com.lotaviods.forFun.animeList.model.InfoRequest

interface AnimeRepository {
    suspend fun getAnimes(): InfoRequest?
    suspend fun postAnime(name: String): Boolean?
    suspend fun removeAnimeByName(name: String): Boolean?
}