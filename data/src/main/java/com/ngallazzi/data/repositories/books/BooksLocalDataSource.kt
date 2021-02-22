package com.ngallazzi.data.repositories.books

import com.ngallazzi.data.entities.BookEntity
import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {

    suspend fun bookmark(book: BookEntity)

    suspend fun unBookmark(book: BookEntity)

    suspend fun getBookmarks(): Flow<List<BookEntity>>
}