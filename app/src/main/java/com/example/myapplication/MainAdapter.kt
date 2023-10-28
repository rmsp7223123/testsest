package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemRecvBinding

class MainAdapter(private var list : List<Memo>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    inner class ViewHolder(var binding : ItemRecvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRecvBinding.inflate(LayoutInflater.from(parent.context),parent,false));
    };

    override fun getItemCount(): Int {
        return list.size;
    };

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvContent.text = list[position].content;
    };

    fun updateData(newList: List<Memo>) {
        list = newList;
        notifyDataSetChanged();
    };
}