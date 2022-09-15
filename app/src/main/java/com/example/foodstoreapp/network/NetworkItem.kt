package com.example.foodstoreapp.network

import com.example.foodstoreapp.data.ItemEntity
import com.example.foodstoreapp.model.Item
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.text.NumberFormat


@JsonClass(generateAdapter = true)
data class NetworkItemContainer(val items: List<NetworkItem>)

@JsonClass(generateAdapter = true)
data class NetworkItem(
    @Json(name = "name") val name: String,
    @Json(name = "image_url") val imageUrl: String,
    @Json(name = "price") val price: String,
    @Json(name = "size") val size: String?,
    @Json(name = "flavor") val flavor: String?,
    @Json(name = "category") val category: String,
    @Json(name = "is_in_promo") val isInPromo: Boolean,
){
    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(price.toDouble())

}

//@JsonClass(generateAdapter = true)
//data class NetworkRating(
//    @Json(name = "stars") val stars: String,
//    @Json(name = "comment") val comment: String
//)


fun NetworkItemContainer.asEntity(): List<ItemEntity> {
    return items.map {
        ItemEntity(
            name = it.name,
            imageUrl = it.imageUrl,
            price = it.price,
            size = it.size,
            flavor = it.flavor,
            category = it.category,
            isInPromo = it.isInPromo
        )
    }
}

fun NetworkItemContainer.asDomainModel(): List<Item> {
    return items.map {
        Item(
            name = it.name,
            imageUrl = it.imageUrl,
            price = it.price,
            size = it.size,
            flavor = it.flavor,
            category = it.category,
            isInPromo = it.isInPromo
        )
    }
}

