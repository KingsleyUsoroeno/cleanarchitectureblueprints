package com.ngallazzi.domain.repositories

import com.ngallazzi.domain.common.Result
import com.ngallazzi.domain.entities.Volume
import kotlinx.coroutines.flow.Flow

/** An abstract definition of a bookRepository used when communicating with the data layer*/
interface BooksRepository {

    suspend fun getRemoteBooks(author: String): Result<List<Volume>>

    suspend fun getBookmarks(): Flow<List<Volume>>

    suspend fun bookmark(book: Volume)

    suspend fun unbookmark(book: Volume)
}