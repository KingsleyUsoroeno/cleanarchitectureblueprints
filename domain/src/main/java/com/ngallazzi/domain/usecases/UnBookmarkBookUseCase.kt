package com.ngallazzi.domain.usecases

import com.ngallazzi.domain.entities.Volume
import com.ngallazzi.domain.repositories.BooksRepository

class UnBookmarkBookUseCase(private val booksRepository: BooksRepository) {
    suspend operator fun invoke(book: Volume) = booksRepository.unbookmark(book)
}