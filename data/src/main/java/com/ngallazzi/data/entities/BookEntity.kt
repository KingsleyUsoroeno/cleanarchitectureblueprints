package com.ngallazzi.data.entities

data class BookEntity(
    val id: String,
    val title: String,
    val authors: List<String>,
    val imageUrl: String?
)