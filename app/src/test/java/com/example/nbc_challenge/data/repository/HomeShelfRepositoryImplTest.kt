package com.example.nbc_challenge.data.repository

import app.cash.turbine.test
import com.example.nbc_challenge.data.model.HomePageModel
import com.example.nbc_challenge.data.model.ShelfModel
import com.example.nbc_challenge.data.source.LocalDataSource
import com.example.nbc_challenge.domain.entity.ShelfType
import com.example.nbc_challenge.domain.repository.HomeShelfRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import com.example.nbc_challenge.domain.entity.Result
import org.junit.jupiter.api.Assertions.*
import java.io.FileNotFoundException

class HomeShelfRepositoryImplTest {

    private lateinit var homeShelfRepo: HomeShelfRepository
    private val localDataSource: LocalDataSource = mockk()

    @Before
    fun setUp() {
        homeShelfRepo = HomeShelfRepositoryImpl(localDataSource)
    }

    @Test
    fun `getHomeShelves emits Loading then Success`() = runTest {
        val dto = HomePageModel(
            page = "HOMEPAGE",
            shelves = listOf(
                ShelfModel(
                    title = "Trending Now",
                    type = "Shelf",
                    items = emptyList()
                )
            )
        )

        every { localDataSource.loadJSONFile(any()) } returns dto

        homeShelfRepo.getHomeShelves().test {
            assertTrue(awaitItem() is Result.Loading)

            val success = awaitItem() as Result.Success
            assertEquals(1, success.value.size)
            assertEquals("Trending Now", success.value.first().title)
            assertEquals(ShelfType.TrendingNow, success.value.first().type)

            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `getHomeShelves emits Loading then Error when data source fails`() = runTest {
        every { localDataSource.loadJSONFile(any()) } throws FileNotFoundException("not found")

        homeShelfRepo.getHomeShelves().test {
            assertTrue(awaitItem() is Result.Loading)
            val err = awaitItem() as Result.Error
            assertTrue(err.message.contains("FileNotFoundException"))
            cancelAndIgnoreRemainingEvents()
        }
    }
  
}