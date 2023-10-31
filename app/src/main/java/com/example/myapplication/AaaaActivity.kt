package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityAaaaBinding

class AaaaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAaaaBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityAaaaBinding.inflate(layoutInflater);
        setContentView(binding.root);
        binding.btn.setOnClickListener { Singleton.doSomething(); };
    }
}