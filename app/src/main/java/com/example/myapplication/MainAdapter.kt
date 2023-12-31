package com.example.myapplication

import android.app.AlertDialog
import android.app.ProgressDialog.show
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemRecvBinding

class MainAdapter(private var list: List<Memo>, private val viewModel: MemoViewModel) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: ItemRecvBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRecvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        );
    };

    override fun getItemCount(): Int {
        return list.size;
    };

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvContent.text = list[position].content;
        holder.binding.cvContent.setOnClickListener {
            showOptionsDialog(holder.binding.root.context, position);
        };
    };

    fun updateData(newList: List<Memo>) {
        list = newList;
        notifyDataSetChanged();
    };

    private fun showOptionsDialog(context: Context, position: Int) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit, null);
        val editTextEditContent = dialogView.findViewById<EditText>(R.id.editTextEditContent);
        val memoToEditOrDelete = list[position];
        editTextEditContent.setText(memoToEditOrDelete.content);
        val parentView = editTextEditContent.parent as? ViewGroup;
        parentView?.removeView(editTextEditContent);

        AlertDialog.Builder(context)
            .setView(editTextEditContent)
            .setTitle("옵션 선택")
            .setNegativeButton("수정") { dialog, _ ->
                val editedContent = editTextEditContent.text.toString();
                memoToEditOrDelete.content = editedContent;
                viewModel.updateMemo(memoToEditOrDelete);
                dialog.dismiss();
            }
            .setPositiveButton("취소") { dialog, _ ->
                dialog.dismiss();
            }
            .setNeutralButton("삭제") { dialog, _ ->
                viewModel.deleteMemo(memoToEditOrDelete);
                dialog.dismiss();
            }
            .show();
    };
}