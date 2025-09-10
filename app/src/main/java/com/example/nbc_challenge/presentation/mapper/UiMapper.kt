package com.example.nbc_challenge.presentation.mapper

import com.example.nbc_challenge.domain.entity.EpisodeItem
import com.example.nbc_challenge.domain.entity.LiveItem
import com.example.nbc_challenge.domain.entity.Shelf
import com.example.nbc_challenge.domain.entity.ShelfItem
import com.example.nbc_challenge.domain.entity.ShowItem
import com.example.nbc_challenge.presentation.model.CardUiState
import com.example.nbc_challenge.presentation.model.ShelfUiState

fun Shelf.toUi(): ShelfUiState = ShelfUiState(
    title = title,
    items = items.map { it.toUi() }
)

fun ShelfItem.toUi(): CardUiState = when (this) {
    is EpisodeItem -> CardUiState(title, imageUrl, subtitle = subtitle, labelBadge = labelBadge)
    is LiveItem -> CardUiState(title, imageUrl, subtitle = subtitle, tagline = tagline)
    is ShowItem -> CardUiState( title, imageUrl,)
}