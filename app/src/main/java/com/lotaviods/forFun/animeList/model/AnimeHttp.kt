package com.lotaviods.forFun.animeList.model

import com.google.firebase.encoders.json.JsonDataEncoderBuilder
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.lotaviods.forFun.animeList.BuildConfig
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
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
    fun postaAnime(nome: String): Boolean? {
        return try {
            val json = """
                {
                    "name": "$nome"
                }
            """.trimIndent()
            val body = json.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

            val request = Request.Builder().url(URL).post(body).build()

            val response = client.newCall(request).execute()
            return response.isSuccessful
        } catch (e: Exception) {
            null
        }
    }


}
