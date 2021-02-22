package com.ngallazzi.cache.data.repository

import com.ngallazzi.cache.data.mapper.BookEntityMapper
import com.ngallazzi.data.entities.BookEntity
import com.ngallazzi.data.repositories.books.BooksLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class BooksLocalDataSourceImpl(
    private val bookDao: com.ngallazzi.cache.data.daos.BookDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val bookEntityMapper: BookEntityMapper = BookEntityMapper()

) : BooksLocalDataSource {

    override suspend fun bookmark(book: BookEntity) = withContext(dispatcher) {
        bookDao.saveBook(bookEntityMapper.mapToCached(book))
    }

    override suspend fun unBookmark(book: BookEntity) = withContext(dispatcher) {
        bookDao.deleteBook(bookEntityMapper.mapToCached(book))
    }

    override suspend fun getBookmarks(): Flow<List<BookEntity>> {
        return bookDao.getSavedBooks().map { bookEntityMapper.mapFromList(it) }
    }
}