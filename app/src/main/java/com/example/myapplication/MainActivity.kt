package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding;
    private lateinit var viewModel: MemoViewModel;
    private lateinit var adapter : MainAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        viewModel = ViewModelProvider(this)[MemoViewModel::class.java];
        viewModel.allMemos.observe(this) {list ->
            adapter.updateData(list);
        };

        adapter = MainAdapter(emptyList(), viewModel);
        binding.recyclerViewMemos.adapter = adapter;
        binding.recyclerViewMemos.layoutManager = LinearLayoutManager(this);

        binding.buttonAddMemo.setOnClickListener {
            val title = binding.editTextSearch.text.toString();
            if (title.isNotEmpty()) {
                val newMemo = Memo(title = title, content = title);
                viewModel.insertMemo(newMemo)
                binding.editTextSearch.text.clear();
            } else {

            };
        };

        binding.buttonSortMemo.setOnClickListener {
            val searchQuery = binding.EditTextSort.text.toString().trim();
            if (searchQuery.isNotEmpty()) {
                viewModel.searchMemos(searchQuery).observe(this) { memos ->
                    adapter.updateData(memos);
                };
            } else {
                viewModel.allMemos.observe(this) { memos ->
                    adapter.updateData(memos);
                };
            };
        };
        binding.btnAaaa.setOnClickListener { startActivity(Intent(this, AaaaActivity::class.java)); };
    };
};