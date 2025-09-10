package com.example.nbc_challenge.presentation.composables

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nbc_challenge.presentation.model.CardUiState

@Composable
fun ShelfItemsRow(
    items: List<CardUiState>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items, key = { "${it.title}|${it.subtitle}|${it.imageUrl}" }) { item ->
            Log.d("Image URL", item.imageUrl)
            ShelfItemCard(item = item)
        }
    }
}