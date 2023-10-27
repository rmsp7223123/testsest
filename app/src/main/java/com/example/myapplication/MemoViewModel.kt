package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemoViewModel(application: Application) : AndroidViewModel(application) {
    private val memoDao: MemoDao;
    private val allMemos: LiveData<List<Memo>>;

    init {
        val database = MemoDatabase.getDatabase(application);
        memoDao = database.memoDao();
        allMemos = memoDao.getAllMemos();
    };

    fun getAllMemos(): LiveData<List<Memo>> {
        return allMemos;
    };

    fun searchMemos(query: String): LiveData<List<Memo>> {
        return memoDao.searchMemos("%$query%");
    };

    fun insertMemo(memo: Memo) {
        viewModelScope.launch(Dispatchers.IO) {
            memoDao.insertMemo(memo);
        };
    };

    fun updateMemo(memo: Memo) {
        viewModelScope.launch(Dispatchers.IO) {
            memoDao.updateMemo(memo);
        };
    };

    fun deleteMemo(memo: Memo) {
        viewModelScope.launch(Dispatchers.IO) {
            memoDao.deleteMemo(memo);
        };
    };
};