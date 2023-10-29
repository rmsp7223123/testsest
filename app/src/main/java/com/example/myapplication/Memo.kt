package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memos")
class Memo (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    var content: String
)