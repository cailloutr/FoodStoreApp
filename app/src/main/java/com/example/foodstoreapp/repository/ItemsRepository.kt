package com.example.foodstoreapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.asLiveData
import com.example.foodstoreapp.data.ItemRoomDatabase
import com.example.foodstoreapp.data.asDomainModel
import com.example.foodstoreapp.model.Item
import com.example.foodstoreapp.network.FoodStoreApi
import com.example.foodstoreapp.network.asEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemsRepository(private val database: ItemRoomDatabase) {

    val items: LiveData<List<Item>> =
        Transformations.map(database.itemDao().getAllItems()) {
            it.asDomainModel()
        }

    val promoItems: LiveData<List<Item>> =
        Transformations.map(database.itemDao().getPromoItem()) {
            it.asDomainModel()
        }

    suspend fun refreshItems() {
        withContext(Dispatchers.IO) {
            val listItems = FoodStoreApi.retrofitService.getItems()
            database.itemDao().insertAll(listItems.asEntity())
        }
    }
}