package com.ngallazzi.cleanarchitectureblueprints

import android.app.Application
import com.ngallazzi.cleanarchitectureblueprints.di.ServiceLocator
import com.ngallazzi.data.repositories.books.BooksRepositoryImpl
import com.ngallazzi.domain.usecases.BookmarkBookUseCase
import com.ngallazzi.domain.usecases.GetBookmarksUseCase
import com.ngallazzi.domain.usecases.GetBooksUseCase
import com.ngallazzi.domain.usecases.UnBookmarkBookUseCase
import com.ngallazzi.presentation.mapper.BookWithStatusMapper
import timber.log.Timber

class CleanArchitectureBlueprintsApplication : Application() {
    private val booksRepository: BooksRepositoryImpl
        get() = ServiceLocator.provideBooksRepository(this)

    val getBooksUseCase: GetBooksUseCase
        get() = GetBooksUseCase(booksRepository)

    val getBookmarksUseCase: GetBookmarksUseCase
        get() = GetBookmarksUseCase(booksRepository)


    val bookmarkBooksUseCase: BookmarkBookUseCase
        get() = BookmarkBookUseCase(booksRepository)

    val unbookmarkBookUseCase: UnBookmarkBookUseCase
        get() = UnBookmarkBookUseCase(booksRepository)

    val bookWithStatusMapper = BookWithStatusMapper()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}