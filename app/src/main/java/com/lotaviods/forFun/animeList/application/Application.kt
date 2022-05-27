package com.lotaviods.forFun.animeList.application

import com.lotaviods.forFun.animeList.di.AnimeModule.animeModule
import org.koin.core.context.GlobalContext.startKoin

class Application : android.app.Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    animeModule
                )
            )
        }
    }


}