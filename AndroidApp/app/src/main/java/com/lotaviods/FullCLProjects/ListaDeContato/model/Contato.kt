package com.lotaviods.FullCLProjects.ListaDeContato.model

data class Contato (
    private val id : Int,
    val nome : String,
    private val numero :  String,
    val email : String
)