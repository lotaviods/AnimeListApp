package com.example.teste.ui.mainactivity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lotaviods.FullCLProjects.ListaDeContato.model.ContatoHttp
import com.lotaviods.FullCLProjects.ListaDeContato.model.InfoRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContatoViewModel:
        ViewModel() {
        val contato = MutableLiveData<InfoRequest>()
        fun procuraAluno(){
                val viewModelScope = CoroutineScope(context = Dispatchers.IO)
                viewModelScope.launch {
                        val resposta : InfoRequest? = ContatoHttp.procuraAluno()
                        contato.postValue(resposta)
                }
        }
}