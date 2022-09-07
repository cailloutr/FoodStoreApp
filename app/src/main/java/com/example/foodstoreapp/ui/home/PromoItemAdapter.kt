package com.example.foodstoreapp.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodstoreapp.databinding.PromoItemViewBinding
import com.example.foodstoreapp.model.ItemTest

class PromoItemAdapter(
    private val onItemClickListener: (ItemTest) -> Unit
): ListAdapter<ItemTest, PromoItemAdapter.ItemViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<ItemTest>() {
            override fun areItemsTheSame(oldItem: ItemTest, newItem: ItemTest): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(
                oldItem: ItemTest,
                newItem: ItemTest,
            ): Boolean {
                return oldItem.name == newItem.name
            }

        }
    }

    class ItemViewHolder(
        private var binding: PromoItemViewBinding
    ): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}