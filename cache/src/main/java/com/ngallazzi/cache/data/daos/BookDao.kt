package com.ngallazzi.cache.data.daos

import androidx.room.*
import com.ngallazzi.cache.data.models.CacheBookEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBook(book: CacheBookEntity)

    @Query("SELECT * FROM book")
    fun getSavedBooks(): Flow<List<CacheBookEntity>>

    @Delete
    suspend fun deleteBook(book: CacheBookEntity)
}