package com.lotaviods.forFun.animeList.ui.main.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lotaviods.forFun.animeList.model.Anime
import com.lotaviods.forFun.animeList.repository.AnimeRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: AnimeRepository
) : ViewModel() {
    var state: ListAnimeAppState by mutableStateOf(ListAnimeAppState.Initial)
        private set

    init {
        viewModelScope.launch {
            fetchAllAnimes()
        }
    }

    fun fetchAllAnimes() {
        viewModelScope.launch {
            state = ListAnimeAppState.Loading

            val response = repository.getAnimes()
            if(response == null) {
                state = ListAnimeAppState.Error
                return@launch
            }
            val animes = mutableListOf<Anime>()
            animes.addAll(response.animeList)
            
            state = ListAnimeAppState.Success(animes)
        }
    }
    /**
     * Todo call api to delete anime!
     */
    fun deleteAnime(animeToBeRemoved: Anime): String {
        val list = (state as? ListAnimeAppState.Success)?.data

        list?.filter { it != animeToBeRemoved }?.toMutableStateList()?.let {
            state = ListAnimeAppState.Success(it)
        }
        return animeToBeRemoved.name
    }
}

sealed class ListAnimeAppState() {
    object Error : ListAnimeAppState()
    object Initial : ListAnimeAppState()
    class Success(val data: List<Anime>) : ListAnimeAppState()
    object Loading : ListAnimeAppState()
}