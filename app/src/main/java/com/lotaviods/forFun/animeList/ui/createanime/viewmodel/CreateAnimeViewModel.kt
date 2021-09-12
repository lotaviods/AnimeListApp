package com.lotaviods.forFun.animeList.ui.createanime.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lotaviods.forFun.animeList.repository.AnimeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateAnimeViewModel: ViewModel() {
    val animeCriado = MutableLiveData<Boolean>()
    private val repository: AnimeRepository = AnimeRepository()

    fun createAnime(nome: String) {
        val viewModelScope = CoroutineScope(context = Dispatchers.IO)
        viewModelScope.launch {
            val resposta = repository.postaAnime(nome)

            if (resposta != null) {
                if (resposta)
                    animeCriado.postValue(true)
                else {
                    animeCriado.postValue(false)
                }
            }else{
                animeCriado.postValue(false)
            }

        }

    }
}