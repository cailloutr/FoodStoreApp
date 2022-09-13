package com.example.foodstoreapp.network

import com.squareup.moshi.Json
import java.text.NumberFormat

data class Item(
    @Json(name = "name") val name: String,
    @Json(name = "image_url") val imageUrl: String,
    @Json(name = "rating") val rating: List<Rating>,
    @Json(name = "price") val price: String,
    @Json(name = "size") val size: String?,
    @Json(name = "flavor") val flavor: List<String>?,
    @Json(name = "category") val category: String,
    @Json(name = "is_in_promo") val isInPromo: Boolean
) {

    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(price.toDouble())

    fun getStarsCount(): String {
        var sum = 0.0
        for (rating in rating) {
            sum += rating.stars.toDouble()
        }

        return "${sum/rating.size} (${rating.size})"
    }
}