package com.lotaviods.forFun.animeList.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Anime (
    val id: String = "",
    val name : String = "",
    val number :  String = "",
    val description : String? = "",
    val createdAt: String = "",
    val imageUrl: String = "https://i.pinimg.com/564x/8b/89/b2/8b89b289cd4c20db0ff88441f514fd76.jpg"
)