package com.lotaviods.forFun.animeList.ui.navigation

sealed class Routes(val route: String) {
    object MainScreen: Routes("main_screen")
    object CreateAnimeScreen: Routes("create_anime_screen")
}