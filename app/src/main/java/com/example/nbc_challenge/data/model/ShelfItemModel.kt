package com.example.nbc_challenge.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ShelfItemModel(
    val type: String,
    val title: String,
    val image: String,
    val subtitle: String? = null,
    val tagline: String? = null,
    val labelBadge: String? = null
)