package com.example.foodstoreapp.model

import java.text.NumberFormat

data class Item(
    val name: String,
    val imageUrl: String,
    val price: String,
    val size: String?,
    val flavor: String?,
    val category: String,
    val isInPromo: Boolean
) {

    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(price.toDouble())

//    fun getStarsCount(): String {
//        var sum = 0.0
//        for (rating in rating) {
//            sum += rating.stars.toDouble()
//        }
//
//        return "${sum/rating.size} (${rating.size})"
//    }
}