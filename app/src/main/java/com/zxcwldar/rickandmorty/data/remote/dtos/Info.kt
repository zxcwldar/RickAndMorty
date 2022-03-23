package com.zxcwldar.rickandmorty.data.remote.dtos

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)