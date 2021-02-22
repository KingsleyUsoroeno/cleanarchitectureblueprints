package com.ngallazzi.cache.data.mapper

import com.ngallazzi.cache.data.models.CacheBookEntity
import com.ngallazzi.data.entities.BookEntity

/**
 * Map a [CacheBookEntity] instance to and from a [BookEntity] instance when data is moving between
 * this later and the Data layer
 */
class BookEntityMapper : EntityMapper<CacheBookEntity, BookEntity> {

    override fun mapFromCached(type: CacheBookEntity): BookEntity {
        return BookEntity(
            id = type.id,
            title = type.title,
            authors = type.authors,
            imageUrl = type.imageUrl
        )
    }

    override fun mapToCached(type: BookEntity): CacheBookEntity {
        return CacheBookEntity(
            id = type.id,
            title = type.title,
            authors = type.authors,
            imageUrl = type.imageUrl
        )
    }


    fun mapFromList(cacheFarmEntity: List<CacheBookEntity>): List<BookEntity> {
        return cacheFarmEntity.map { mapFromCached(it) }
    }

}