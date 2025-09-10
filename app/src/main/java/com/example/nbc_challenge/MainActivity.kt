package com.example.nbc_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.nbc_challenge.presentation.composables.BottomNavigationBar
import com.example.nbc_challenge.presentation.composables.HomeRoute
import com.example.nbc_challenge.presentation.theme.Nbc_challengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Nbc_challengeTheme {
                val backgroundColor = remember {
                    Brush.verticalGradient(
                        listOf(Color(0xFF0089A8), Color(0xFF500053))
                    )
                }
                var selected by rememberSaveable { mutableStateOf(0) }

                Box(
                    Modifier
                        .fillMaxSize()
                        .background(backgroundColor)
                ) {
                    Scaffold(
                        containerColor = Color.Transparent,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        bottomBar = {
                            BottomNavigationBar(
                                selected = selected,
                                onSelect = { selected = it }
                            )
                        }
                    ) { padding ->
                        Box(Modifier.padding(padding)) {
                            HomeRoute()
                        }
                    }
                }
            }
        }
    }
}