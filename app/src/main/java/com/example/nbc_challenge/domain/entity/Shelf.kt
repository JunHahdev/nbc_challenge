package com.example.nbc_challenge.domain.entity

data class Shelf(
    val type: ShelfType,
    val title: String,
    val items: List<ShelfItem>
)

enum class ShelfType(val title: String) {
    ContinueWatching("Continue Watching"),
    TrendingNow("Trending Now"),
    LatestEpisodes("Latest Episodes"),
    Unknown("Unknown");

    companion object {
        fun fromTitle(t: String): ShelfType =
            entries.firstOrNull { it.title.equals(t, ignoreCase = true) } ?: Unknown
    }
}
