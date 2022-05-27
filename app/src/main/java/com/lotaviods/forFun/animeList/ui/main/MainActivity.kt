package com.lotaviods.forFun.animeList.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lotaviods.forFun.animeList.ui.theme.AppTheme
import com.lotaviods.forFun.animeList.ui.component.MainScreen
import com.lotaviods.forFun.animeList.ui.component.create.CreateAnimeScreen
import com.lotaviods.forFun.animeList.ui.main.viewModel.MainViewModel
import com.lotaviods.forFun.animeList.ui.navigation.Routes
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()

    /**
     *  Todo create components to create and edit anime
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface {
                    val navController = rememberNavController()

                    NavHost(navController = navController,
                        startDestination = Routes.MainScreen.route) {
                        composable(Routes.MainScreen.route) { _ ->
                            MainScreen(getAnimes = {
                                viewModel.fetchAllAnimes()
                            }, onDelete = {
                                viewModel.deleteAnime(it)
                            }, state = viewModel.state,
                                toAddPage = {
                                    navController.navigate(Routes.CreateAnimeScreen.route)
                                })
                        }
                        composable(Routes.CreateAnimeScreen.route) {
                            CreateAnimeScreen()
                        }
                    }

                }
            }
        }
    }
}