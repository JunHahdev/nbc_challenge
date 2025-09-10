package com.example.nbc_challenge.domain.entity

sealed interface ShelfItem {
    val title: String
    val imageUrl: String
}

data class EpisodeItem(
    override val title: String,
    val subtitle: String?,
    override val imageUrl: String,
    val labelBadge: String?
) : ShelfItem

data class LiveItem(
    override val title: String,
    val tagline: String?,
    val subtitle: String?,
    override val imageUrl: String,
) : ShelfItem

data class ShowItem(
    override val title: String,
    override val imageUrl: String,
) : ShelfItem
