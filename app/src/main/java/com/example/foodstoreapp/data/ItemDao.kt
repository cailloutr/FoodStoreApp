package com.example.foodstoreapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.foodstoreapp.model.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM items ORDER BY name ASC ")
    fun getAllItems(): LiveData<List<ItemEntity>>

    @Query("SELECT * FROM items WHERE is_in_promo = 1")
    fun getPromoItem(): LiveData<List<ItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<ItemEntity>)

//    @Transaction
//    @Query("SELECT * FROM items")
//    fun getItemWithRatings(): List<ItemWithRating>
}