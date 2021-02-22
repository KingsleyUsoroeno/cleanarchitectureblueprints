package com.ngallazzi.cache.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class CacheBookEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val authors: List<String>,
    val imageUrl: String?
)