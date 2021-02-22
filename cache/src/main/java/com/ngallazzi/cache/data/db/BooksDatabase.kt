package com.ngallazzi.cache.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ngallazzi.cache.data.converters.Converters
import com.ngallazzi.cache.data.models.CacheBookEntity

@Database(entities = [CacheBookEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class BooksDatabase : RoomDatabase() {
    abstract fun bookDao(): com.ngallazzi.cache.data.daos.BookDao

    companion object {
        @Volatile
        private var INSTANCE: BooksDatabase? = null

        fun getDatabase(appContext: Context): BooksDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    appContext, BooksDatabase::class.java,
                    BooksDatabase::class.simpleName!!
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}