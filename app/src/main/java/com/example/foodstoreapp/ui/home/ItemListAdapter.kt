package com.example.foodstoreapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodstoreapp.databinding.PromoItemViewBinding
import com.example.foodstoreapp.network.Item

const val TAG_ADAPTER = "ListItemAdapter"
class ItemListAdapter(
    val clickListener: ItemListener
) : ListAdapter<Item, ItemListAdapter.ItemViewHolder>(DiffCallback) {

    class ItemViewHolder(
        var binding: PromoItemViewBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            PromoItemViewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Item, newItem: Item) =
            oldItem.name == newItem.name && oldItem.imageUrl == newItem.imageUrl
    }
}

class ItemListener(val clickListener: (item: Item) -> Unit) {
    fun onClick(item: Item) = clickListener(item)
}
