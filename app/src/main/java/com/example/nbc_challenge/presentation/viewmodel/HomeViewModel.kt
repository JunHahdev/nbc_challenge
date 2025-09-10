package com.example.nbc_challenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nbc_challenge.domain.usecase.GetHomeShelvesUseCase
import com.example.nbc_challenge.presentation.model.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import com.example.nbc_challenge.domain.entity.Result
import com.example.nbc_challenge.presentation.mapper.toUi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getHomeShelvesUseCase: GetHomeShelvesUseCase
) : ViewModel() {

    val state: StateFlow<HomeUiState> = getHomeShelvesUseCase()
        .map { result ->
            when (result) {
                is Result.Loading -> HomeUiState(isLoading = true)
                is Result.Error   -> HomeUiState(error = result.message)
                is Result.Success -> HomeUiState(
                    success = result.value.map { it.toUi() }
                )
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), HomeUiState())
}