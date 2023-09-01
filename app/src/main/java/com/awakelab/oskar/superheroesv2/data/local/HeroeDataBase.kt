package com.awakelab.oskar.superheroesv2.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


    @Database(entities = [HeroeEntity::class], version = 1)
    abstract class HeroeDataBase() : RoomDatabase() {
        abstract fun getHeroeDao(): HeroeDao

        companion object {
            @Volatile
            private var INSTANCE: HeroeDataBase? = null

            fun getDatabase(context: Context): HeroeDataBase {
                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext, HeroeDataBase::class.java, "super_heroe_ddbb"
                    ).build()

                    INSTANCE = instance
                    return instance
                }
            }
        }
    }