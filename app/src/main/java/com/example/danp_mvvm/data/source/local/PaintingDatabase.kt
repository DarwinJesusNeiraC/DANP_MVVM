package com.example.danp_mvvm.data.source.local

import PaintingDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.danp_mvvm.data.model.Painting

@Database(entities = [Painting::class], version = 1)
abstract class PaintingDatabase : RoomDatabase() {
    abstract fun paintingDao(): PaintingDao

    companion object {
        @Volatile
        private var INSTANCE: PaintingDatabase? = null

        fun getDatabase(context: Context): PaintingDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PaintingDatabase::class.java,
                    "painting_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
