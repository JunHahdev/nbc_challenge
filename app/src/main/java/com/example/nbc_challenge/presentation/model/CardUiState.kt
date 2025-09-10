package com.example.nbc_challenge.presentation.model

data class CardUiState(
    val title: String,
    val imageUrl: String,
    val subtitle: String? = null,
    val tagline: String? = null,
    val labelBadge: String? = null,
)