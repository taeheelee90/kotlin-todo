package com.example.memo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ToDoEntity::class), version = 1)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun toDoDAO() : ToDoDAO

    companion object{
        var INSTANCE : ToDoDatabase? = null

        fun getInstance(context : Context) : ToDoDatabase? {
            if(INSTANCE == null){
                synchronized(ToDoDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, ToDoDatabase::class.java, "todo.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}