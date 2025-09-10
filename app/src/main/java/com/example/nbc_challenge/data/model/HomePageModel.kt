package com.example.nbc_challenge.data.model

import kotlinx.serialization.Serializable

@Serializable
data class HomePageModel (
    val page: String,
    val shelves: List<ShelfModel>
)