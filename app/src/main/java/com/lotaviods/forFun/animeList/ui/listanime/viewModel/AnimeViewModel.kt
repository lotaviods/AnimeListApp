package com.lotaviods.forFun.animeList.ui.listanime.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lotaviods.forFun.animeList.model.InfoRequest
import com.lotaviods.forFun.animeList.repository.AnimeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimeViewModel() :
    ViewModel() {
    private val repository: AnimeRepository = AnimeRepository()
    val anime = MutableLiveData<InfoRequest>()
    val erro = MutableLiveData<String>()
    private val comandoResposta = MutableLiveData<Boolean>()

    fun searchAnimes() {

        val viewModelScope = CoroutineScope(context = Dispatchers.IO)
        viewModelScope.launch {
            val resposta: InfoRequest? = repository.getAnimes()
            if (resposta != null) {
                anime.postValue(resposta!!)
            } else {
                erro.postValue("Erro ao se conectar com o servidor")
            }

        }
    }
    fun removeAnime(name: String?):MutableLiveData<Boolean> {
        val viewModelScope = CoroutineScope(context = Dispatchers.IO)
        viewModelScope.launch {
            if (name != null) {
                val resposta = repository.removeAnime(name)

                if (resposta == true){
                    comandoResposta.postValue(true)
                }else{
                    erro.postValue("Erro ao excluir")
                }

            }
        }
        return comandoResposta
    }
}