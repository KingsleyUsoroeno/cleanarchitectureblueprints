package com.ngallazzi.remote.mapper

import com.ngallazzi.data.entities.BookEntity
import com.ngallazzi.remote.data.model.BooksApiResponse

/**
 * Map a [BooksApiResponse] to and from a [BookEntity] instance when data is moving between
 * this later and the Data layer
 */
class BookEntityMapper : EntityMapper<BooksApiResponse, List<BookEntity>> {
    override fun mapFromRemote(type: BooksApiResponse): List<BookEntity> {
        return type.items.map {
            BookEntity(
                id = it.id,
                title = it.volumeInfo.title,
                authors = it.volumeInfo.authors,
                imageUrl = it.volumeInfo.imageLinks?.thumbnail?.replace("http", "https")
            )
        }
    }

}