package com.lotaviods.fullclprojects.listadecontato.model

import android.widget.Toast
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import java.util.concurrent.TimeUnit
import kotlin.coroutines.coroutineContext

object ContatoHttp {
private const val URL = "http://10.0.2.2:8080/api/contatos/?itensPorPagina=9999999"
    private val client =  OkHttpClient().newBuilder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .build()
    fun procuraAluno(): InfoRequest? {
        return try {
            val request = Request.Builder().url(URL)
                .build()
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            Gson().fromJson(json, InfoRequest::class.java)
        }catch (e: Exception){
            null
        }
    }

}