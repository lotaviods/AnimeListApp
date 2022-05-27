package com.lotaviods.forFun.animeList.api.retrofit.service

import com.lotaviods.forFun.animeList.model.InfoRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface AnimeService {
    @GET("anime")
    suspend fun getAllAnimes(): Response<InfoRequest>

    @POST("anime")
    suspend fun postAnime(@Field("name") name: String): Response<ResponseBody>

    @DELETE("anime")
    suspend fun deleteAnime(@Field("name") name: String): Response<ResponseBody>
}