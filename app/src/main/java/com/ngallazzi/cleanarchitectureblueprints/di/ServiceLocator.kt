package com.ngallazzi.cleanarchitectureblueprints.di

import android.content.Context
import com.ngallazzi.cache.data.db.BooksDatabase
import com.ngallazzi.cache.data.repository.BooksLocalDataSourceImpl
import com.ngallazzi.cleanarchitectureblueprints.BuildConfig
import com.ngallazzi.data.mappers.BookEntityMapper
import com.ngallazzi.data.repositories.books.BooksLocalDataSource
import com.ngallazzi.data.repositories.books.BooksRepositoryImpl
import com.ngallazzi.remote.repository.BooksRemoteDataSourceImpl
import kotlinx.coroutines.Dispatchers

object ServiceLocator {
    private var database: BooksDatabase? = null
    private val networkModule by lazy {
        com.ngallazzi.remote.api.NetworkModule()
    }
    private val bookEntityMapper by lazy {
        BookEntityMapper()
    }

    @Volatile
    var booksRepository: BooksRepositoryImpl? = null

    fun provideBooksRepository(context: Context): BooksRepositoryImpl {
        // useful because this method can be accessed by multiple threads
        synchronized(this) {
            return booksRepository ?: createBooksRepository(context)
        }
    }

    private fun createBooksRepository(context: Context): BooksRepositoryImpl {
        val newRepo =
            BooksRepositoryImpl(
                createBooksLocalDataSource(context),
                BooksRemoteDataSourceImpl(
                    networkModule.createBooksApi(BuildConfig.GOOGLE_APIS_ENDPOINT)
                )
            )
        booksRepository = newRepo
        return newRepo
    }

    private fun createBooksLocalDataSource(context: Context): BooksLocalDataSource {
        val database = database ?: createDataBase(context)
        return BooksLocalDataSourceImpl(
            database.bookDao(),
            Dispatchers.IO
        )
    }

    private fun createDataBase(context: Context): BooksDatabase {
        val result = com.ngallazzi.cache.data.db.BooksDatabase.getDatabase(context)
        database = result
        return result
    }
}