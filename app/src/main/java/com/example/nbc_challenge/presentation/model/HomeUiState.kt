package com.example.nbc_challenge.presentation.model

data class HomeUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: List<ShelfUiState> = emptyList()
)