package com.lotaviods.fullclprojects.listadecontato.ui.mainactivity.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lotaviods.fullclprojects.listadecontato.model.ContatoHttp
import com.lotaviods.fullclprojects.listadecontato.model.InfoRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContatoViewModel() :
    ViewModel() {
    val contato = MutableLiveData<InfoRequest>()
    val erro = MutableLiveData<String>()
    fun procuraAluno() {

        val viewModelScope = CoroutineScope(context = Dispatchers.IO)
        viewModelScope.launch {
            val resposta: InfoRequest? = ContatoHttp.procuraAluno()
            if (resposta != null) {
                contato.postValue(resposta)
            } else {
                erro.postValue("Erro ao se conectar com o servidor")
            }

        }
    }
}