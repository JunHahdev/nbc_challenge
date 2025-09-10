package com.example.nbc_challenge.domain.usecase

import com.example.nbc_challenge.domain.entity.Shelf
import com.example.nbc_challenge.domain.entity.Result
import com.example.nbc_challenge.domain.repository.HomeShelfRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHomeShelvesUseCase @Inject constructor(
    private val repository: HomeShelfRepository
) {
    operator fun invoke(): Flow<Result<List<Shelf>>> =
        repository.getHomeShelves()
}

