package com.example.foodstoreapp

import android.app.Application
import com.example.foodstoreapp.data.ItemRoomDatabase

class FoodStoreApplication : Application() {
    val database: ItemRoomDatabase by lazy { ItemRoomDatabase.getDatabase(this) }
}