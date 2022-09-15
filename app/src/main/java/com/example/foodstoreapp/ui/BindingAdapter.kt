package com.example.foodstoreapp.ui

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodstoreapp.R
import com.example.foodstoreapp.model.Item
import com.example.foodstoreapp.ui.home.ItemListAdapter

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imageUrl = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide
            .with(imageView.context)
            .load(imageUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_image_placeholder)
            .into(imageView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Item>?) {
    val adapter = recyclerView.adapter as ItemListAdapter
    adapter.submitList(data)
}
