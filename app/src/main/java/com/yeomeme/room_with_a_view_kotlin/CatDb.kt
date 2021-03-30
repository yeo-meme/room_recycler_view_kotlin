package com.yeomeme.room_with_a_view_kotlin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**

 * Created by yeomeme@gmail.com on 2021-03-30
 *
 */
@Database(entities = [Cat::class], version = 1)
abstract class CatDb : RoomDatabase() {
    abstract fun catDao() : CatDao

    companion object {
        private var INSTANCE : CatDb? = null

        fun getInstance(context: Context) : CatDb? {
            if (INSTANCE == null) {
                synchronized(CatDb::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    CatDb::class.java, "cat.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}