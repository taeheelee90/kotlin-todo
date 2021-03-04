package com.example.memo

import androidx.room.*

@Dao
interface ToDoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: ToDoEntity)

    @Query("SELECT * FROM toDo")
    fun getAll() : List<ToDoEntity>

    @Delete
    fun delete(todo : ToDoEntity)
}