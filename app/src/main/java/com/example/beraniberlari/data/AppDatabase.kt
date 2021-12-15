package com.example.beraniberlari.data

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.beraniberlari.data.model.AppCustomPreset
import com.example.beraniberlari.data.model.Run
import com.example.beraniberlari.data.model.UserToken
import com.example.beraniberlari.data.worker.AppCustomPresetWorker


/**
 * The Room database for this app
 */
@Database(entities = [ UserToken::class, AppCustomPreset::class, Run::class], version = 2, exportSchema = false)

@TypeConverters(CoverterBitmap::class)

abstract class AppDatabase : RoomDatabase() {
    abstract fun tokenDao(): TokenDao
    abstract fun runDao(): RunDao
    abstract fun appCustomDao() : AppCustomDao

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {

            val DATABASE_NAME = "app-db"
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<AppCustomPresetWorker>().build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
