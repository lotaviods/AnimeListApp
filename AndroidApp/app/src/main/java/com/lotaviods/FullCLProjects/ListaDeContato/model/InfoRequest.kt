package com.lotaviods.FullCLProjects.ListaDeContato.model

import com.google.gson.annotations.SerializedName

data class InfoRequest(
    val sucesso : Boolean,

    val paginaAtual: Int,

    @SerializedName("quandidadDeContatos")
    val quantidadeDeContatos: Int,

    val conteudoResposta: List<Contato>
)