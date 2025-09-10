package com.example.nbc_challenge.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ShelfModel(
    val title: String,
    val type: String,
    val items: List<ShelfItemModel>
)