package com.example.nbc_challenge.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.nbc_challenge.presentation.model.CardUiState

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ShelfItemCard(
    item: CardUiState,
    modifier: Modifier = Modifier
) {
    Column(modifier.width(160.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RectangleShape,
        ) {
           Box() {
               GlideImage(
                   model = item.imageUrl,
                   contentDescription = "Image description",
                   modifier = Modifier.fillMaxSize()
               )

               item.labelBadge?.let {
                   ShelfBadge(
                       it,
                       modifier = Modifier
                           .align(Alignment.TopStart)
                   )
               }

           }

        }

        Spacer(Modifier.height(8.dp))

        Column(Modifier.fillMaxWidth(0.80f)) {
            Text(
                item.title,
                maxLines = 2,
                style = MaterialTheme.typography.labelSmall,
                color = Color.White
            )
            item.subtitle?.let {
                Text(
                    it,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color(0xFFD3D3D3)
                )
            }
        }
        Spacer(Modifier.height(8.dp))
    }
}