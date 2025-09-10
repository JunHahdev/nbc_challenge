package com.example.nbc_challenge.data.source

import android.content.Context
import com.example.nbc_challenge.data.model.HomePageModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    @ApplicationContext private val context: Context,
    private val json: Json
) {
    fun loadJSONFile(fileName: String = "homepage.json"): HomePageModel {
        val text = context.assets.open(fileName).bufferedReader().use { it.readText() }
        return json.decodeFromString<HomePageModel>(text)
    }
}