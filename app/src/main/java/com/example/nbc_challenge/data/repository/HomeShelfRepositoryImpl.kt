package com.example.nbc_challenge.data.repository

import com.example.nbc_challenge.data.mapper.toDomain
import com.example.nbc_challenge.data.source.LocalDataSource
import com.example.nbc_challenge.domain.entity.Shelf
import com.example.nbc_challenge.domain.repository.HomeShelfRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import com.example.nbc_challenge.domain.entity.Result
import kotlinx.coroutines.Dispatchers


class HomeShelfRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
) : HomeShelfRepository {

    override fun getHomeShelves(): Flow<Result<List<Shelf>>> = flow {
        emit(Result.Loading)
        val shelves = fetchShelvesFromLocal()
        emit(shelves)
    }

    private suspend fun fetchShelvesFromLocal(): Result<List<Shelf>> = withContext(Dispatchers.IO) {
        try {
            delay(300)
            val page = localDataSource.loadJSONFile()
            Result.Success(page.shelves.map { it.toDomain() })
        } catch (t: Throwable) {
            val msg = "${t::class.simpleName}: ${t.message ?: "no message"}"
            Result.Error(msg, t)
        }
    }
}