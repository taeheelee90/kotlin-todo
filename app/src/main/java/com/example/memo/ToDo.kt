package com.example.memo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toDo")
data class ToDoEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    var memo : String = "")