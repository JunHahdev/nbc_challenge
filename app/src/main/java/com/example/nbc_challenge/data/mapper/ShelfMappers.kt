package com.example.nbc_challenge.data.mapper

import com.example.nbc_challenge.data.model.ShelfItemModel
import com.example.nbc_challenge.data.model.ShelfModel
import com.example.nbc_challenge.domain.entity.EpisodeItem
import com.example.nbc_challenge.domain.entity.LiveItem
import com.example.nbc_challenge.domain.entity.Shelf
import com.example.nbc_challenge.domain.entity.ShelfItem
import com.example.nbc_challenge.domain.entity.ShelfType
import com.example.nbc_challenge.domain.entity.ShowItem

fun ShelfItemModel.toDomain(): ShelfItem {
    return when (type) {
        "Episode" -> EpisodeItem(
            title = title,
            subtitle = subtitle,
            imageUrl = image,
            labelBadge = labelBadge
        )
        "Live" -> LiveItem(
            title = title,
            tagline = tagline,
            subtitle = subtitle,
            imageUrl = image,
        )
        "Show" -> ShowItem(
            title = title,
            imageUrl = image,
        )
        else -> ShowItem( title = title, imageUrl = image)
    }
}

fun ShelfModel.toDomain(): Shelf =
    Shelf(
        type = ShelfType.fromTitle(title),
        title = title,
        items = items.map { it.toDomain() }
    )