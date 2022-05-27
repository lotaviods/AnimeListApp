package com.lotaviods.forFun.animeList.model

import com.fasterxml.jackson.annotation.JsonProperty

class InfoRequest(
    @JsonProperty("AnimeList")
    val animeList : List<Anime> = listOf(),
)