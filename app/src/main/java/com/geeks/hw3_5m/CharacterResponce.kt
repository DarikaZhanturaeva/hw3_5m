package com.geeks.hw3_5m

import com.google.gson.annotations.SerializedName

class CharacterResponse(
    val info: Info,
    val results: List<Character>
)

class Info(
    val pages: Int,
    val next: String? = null,
    val prev: String? = null
)

class Character(
    val id: Int,
    val name: String,
    val image: String
)