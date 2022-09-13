package com.example.foodstoreapp.network

import com.squareup.moshi.Json

data class Rating(
    @Json(name = "stars") val stars: String,
    @Json(name = "comment") val comment: String
)