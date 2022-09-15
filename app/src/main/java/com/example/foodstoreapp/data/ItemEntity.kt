package com.example.foodstoreapp.data

import androidx.room.*
import com.example.foodstoreapp.model.Item

@Entity(tableName = "items")
data class ItemEntity(

    @PrimaryKey
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "price")
    val price: String,
    @ColumnInfo(name = "size")
    val size: String?,
    @ColumnInfo(name = "flavor")
    val flavor: String?,
    @ColumnInfo(name = "category")
    val category: String,
    @ColumnInfo(name = "is_in_promo")
    val isInPromo: Boolean,
)

//@Entity(tableName = "ratings")
//data class RatingEntity(
//    @PrimaryKey val itemId: String,
//    @ColumnInfo(name = "item_rating_id") val itemRatingId: String,
//    val stars: String,
//    val comment: String
//)
//
//
//data class ItemWithRating(
//    @Embedded val item: ItemEntity,
//    @Relation(
//        parentColumn = "image_url",
//        entityColumn = "item_rating_id"
//    )
//    val ratings: List<RatingEntity>
//)


fun List<ItemEntity>.asDomainModel(): List<Item> {
    return map {
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