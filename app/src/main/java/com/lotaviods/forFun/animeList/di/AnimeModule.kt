package com.lotaviods.forFun.animeList.di

import com.lotaviods.forFun.animeList.BuildConfig
import com.lotaviods.forFun.animeList.api.retrofit.RetrofitClient
import com.lotaviods.forFun.animeList.api.retrofit.service.AnimeService
import com.lotaviods.forFun.animeList.repository.AnimeRepository
import com.lotaviods.forFun.animeList.repository.AnimeRepositoryImpl
import com.lotaviods.forFun.animeList.ui.main.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AnimeModule {
    val animeModule = module {
        single<AnimeRepository> {
            AnimeRepositoryImpl(
                get()
            )
        }
        viewModel {
            MainViewModel(get())
        }
        single<AnimeService>{
            get<RetrofitClient>().animeService
        }
        single {
            RetrofitClient(BuildConfig.API_URL)
        }
    }
}