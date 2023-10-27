package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MemoDao {
    @Query("SELECT * FROM memos")
    fun getAllMemos(): LiveData<List<Memo>>;

    @Query("SELECT * FROM memos WHERE title LIKE :searchQuery OR content LIKE :searchQuery")
    fun searchMemos(searchQuery: String): LiveData<List<Memo>>;

    @Insert
    suspend fun insertMemo(memo: Memo);

    @Update
    suspend fun updateMemo(memo: Memo);

    @Delete
    suspend fun deleteMemo(memo: Memo);
}