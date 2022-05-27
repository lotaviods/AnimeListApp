package com.lotaviods.forFun.animeList.repository

import android.util.Log
import com.lotaviods.forFun.animeList.api.retrofit.service.AnimeService
import com.lotaviods.forFun.animeList.model.InfoRequest

class AnimeRepositoryImpl(private val animeService: AnimeService) : AnimeRepository {

    override suspend fun getAnimes(): InfoRequest? {
        try {
            val call = animeService.getAllAnimes()
            return call.body()
        } catch (e: Exception) {
            Log.e(TAG, "getAnimes: ", e)
        }
        return null
    }

    override suspend fun postAnime(name: String): Boolean? {
        try {
            val call = animeService.postAnime(name)
            return call.isSuccessful
        } catch (e: Exception) {
            Log.e(TAG, "getAnimes: ", e)
        }
        return null
    }

    override suspend fun removeAnimeByName(name: String): Boolean? {
        try {
            val call = animeService.deleteAnime(name)
            return call.isSuccessful
        } catch (e: Exception) {
            Log.e(TAG, "getAnimes: ", e)
        }
        return null
    }

    companion object {
        private const val TAG = "AnimeRepositoryImpl"
    }
}