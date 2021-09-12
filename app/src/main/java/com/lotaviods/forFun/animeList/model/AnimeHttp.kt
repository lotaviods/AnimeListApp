package com.lotaviods.forFun.animeList.model

import com.google.gson.Gson
import com.lotaviods.forFun.animeList.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

object AnimeHttp {
    private const val URL = BuildConfig.API_URL

    private val client = OkHttpClient().newBuilder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .build()

    fun searchAnimes(): InfoRequest? {
        return try {
            val request = Request.Builder().url(URL)
                .build()
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            Gson().fromJson(json, InfoRequest::class.java)
        } catch (e: Exception) {
            null
        }
    }


}
