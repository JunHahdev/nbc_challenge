package com.example.nbc_challenge.domain.repository

import com.example.nbc_challenge.domain.entity.Shelf
import kotlinx.coroutines.flow.Flow
import com.example.nbc_challenge.domain.entity.Result

interface HomeShelfRepository {

    fun getHomeShelves(): Flow<Result<List<Shelf>>>
}