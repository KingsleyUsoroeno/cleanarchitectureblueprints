package com.ngallazzi.remote.repository

import com.ngallazzi.data.entities.BookEntity
import com.ngallazzi.data.repositories.books.BooksRemoteDataSource
import com.ngallazzi.domain.common.Result
import com.ngallazzi.remote.api.BooksApi
import com.ngallazzi.remote.mapper.BookEntityMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BooksRemoteDataSourceImpl(
    private val api: BooksApi,
    private val mapper: BookEntityMapper = BookEntityMapper()

) : BooksRemoteDataSource {
    override suspend fun getBooks(author: String): Result<List<BookEntity>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getBooks(author)
                if (response.isSuccessful && response.body() != null) {
                    return@withContext Result.Success(mapper.mapFromRemote(response.body()!!))
                } else {
                    return@withContext Result.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext Result.Error(e)
            }
        }
    }
}