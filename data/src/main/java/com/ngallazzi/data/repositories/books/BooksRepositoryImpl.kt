package com.ngallazzi.data.repositories.books

import com.ngallazzi.data.mappers.BookEntityMapper
import com.ngallazzi.domain.common.Result
import com.ngallazzi.domain.entities.Volume
import com.ngallazzi.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/** A concrete implementation of the BooksRepository used when communicating with the domain layer */
class BooksRepositoryImpl(
    private val localDataSource: BooksLocalDataSource,
    private val remoteDataSource: BooksRemoteDataSource,
    private val bookEntityMapper: BookEntityMapper = BookEntityMapper()
) : BooksRepository {

    override suspend fun getRemoteBooks(author: String): Result<List<Volume>> {
        return when (val result = remoteDataSource.getBooks(author)) {
            is Result.Success -> {
                Result.Success(result.data.map { bookEntityMapper.toVolume(it) })
            }
            is Result.Error -> {
                Result.Error(result.exception)
            }
        }
    }

    override suspend fun getBookmarks(): Flow<List<Volume>> {
        return localDataSource.getBookmarks().map { bookEntity ->
            bookEntity.map { bookEntityMapper.toVolume(it) }
        }
    }

    override suspend fun bookmark(book: Volume) {
        localDataSource.bookmark(book = bookEntityMapper.toBookEntity(book))
    }

    override suspend fun unbookmark(book: Volume) {
        localDataSource.unBookmark(book = bookEntityMapper.toBookEntity(book))
    }
}