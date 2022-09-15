package com.example.foodstoreapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


data class Rating(
    val stars: String,
    val comment: String
)