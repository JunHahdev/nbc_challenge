package com.example.nbc_challenge.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShelfBadge(badgeLabel: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.White)
    ) {
        Text(
            text = badgeLabel,
            fontSize = 10.sp,
            modifier = Modifier
                .padding(2.dp),
        )
    }
}