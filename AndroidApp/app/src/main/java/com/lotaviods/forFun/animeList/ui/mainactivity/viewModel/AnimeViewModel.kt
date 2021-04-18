package com.lotaviods.forFun.animeList.ui.mainactivity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lotaviods.forFun.animeList.model.AnimeHttp
import com.lotaviods.forFun.animeList.model.InfoRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimeViewModel() :
    ViewModel() {
    val anime = MutableLiveData<InfoRequest>()
    val erro = MutableLiveData<String>()
    fun searchAnimes() {

        val viewModelScope = CoroutineScope(context = Dispatchers.IO)
        viewModelScope.launch {
            val resposta: InfoRequest? = AnimeHttp.searchAnimes()
            if (resposta != null) {
                anime.postValue(resposta)
            } else {
                erro.postValue("Erro ao se conectar com o servidor")
            }

        }
    }
}