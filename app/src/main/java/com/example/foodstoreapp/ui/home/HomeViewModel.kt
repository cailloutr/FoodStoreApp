package com.example.foodstoreapp.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.bumptech.glide.Glide.init
import com.example.foodstoreapp.data.ItemRoomDatabase
import com.example.foodstoreapp.data.ItemRoomDatabase.Companion.getDatabase
import com.example.foodstoreapp.model.Item
import com.example.foodstoreapp.network.FoodStoreApi
import com.example.foodstoreapp.network.asDomainModel
import com.example.foodstoreapp.repository.ItemsRepository
import kotlinx.coroutines.launch
import java.io.IOException

enum class FoodStoreApiStatus { LOADING, ERROR, DONE }

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val itemsRepository = ItemsRepository(getDatabase(application))

    private val _status = MutableLiveData<FoodStoreApiStatus>()
    val status: LiveData<FoodStoreApiStatus> = _status

    val listItems = itemsRepository.promoItems

//    private val _listItem = MutableLiveData<List<Item>>()
//    val listItem: LiveData<List<Item>> = _listItem

    init {
        refreshFromRepository()
    }

    private fun refreshFromRepository() {
        viewModelScope.launch {
            _status.value = FoodStoreApiStatus.LOADING
            try {
                itemsRepository.refreshItems()
                _status.value = FoodStoreApiStatus.DONE
            } catch (networkError: IOException) {
                _status.value = FoodStoreApiStatus.ERROR
            }
        }
    }

    private fun getAllItems(): List<Item>? {
        if (itemsRepository.items.value.isNullOrEmpty()) {
            return listOf()
        }
        return itemsRepository.items.value
    }


//    fun getItem() {
//        viewModelScope.launch {
//            _status.value = FoodStoreApiStatus.LOADING
//            try {
//                _listItem.value = FoodStoreApi.retrofitService.getItems().asDomainModel()
//                _status.value = FoodStoreApiStatus.DONE
//            } catch (e: Exception) {
//                _status.value = FoodStoreApiStatus.ERROR
//                _listItem.value = listOf()
//            }
//        }
//    }
}

class HomeViewModelFactory(
    private val app: Application,
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

