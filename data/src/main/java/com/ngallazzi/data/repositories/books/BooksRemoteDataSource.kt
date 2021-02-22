package com.ngallazzi.data.repositories.books

import com.ngallazzi.data.entities.BookEntity
import com.ngallazzi.domain.common.Result

interface BooksRemoteDataSource {
    suspend fun getBooks(author: String): Result<List<BookEntity>>
}