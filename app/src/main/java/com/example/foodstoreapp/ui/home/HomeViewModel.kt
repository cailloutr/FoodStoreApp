package com.example.foodstoreapp.ui.home

import androidx.lifecycle.*
import com.example.foodstoreapp.network.Item
import com.example.foodstoreapp.network.FoodStoreApi
import kotlinx.coroutines.launch

enum class FoodStoreApiStatus { LOADING, ERROR, DONE }

class HomeViewModel(
    //private val itemDao: ItemDao,
) : ViewModel() {

    private val _status = MutableLiveData<FoodStoreApiStatus>()
    val status: LiveData<FoodStoreApiStatus> = _status

    private val _listItem = MutableLiveData<List<Item>>()
    val listItem: LiveData<List<Item>> = _listItem


    fun getItem() {
        viewModelScope.launch {
            _status.value = FoodStoreApiStatus.LOADING
            try {
                _listItem.value = FoodStoreApi.retrofitService.getItems()
                _status.value = FoodStoreApiStatus.DONE
            } catch (e: Exception) {
                _status.value = FoodStoreApiStatus.ERROR
                _listItem.value = listOf()
            }
        }
    }
}

//class HomeViewModelFactory(
//    private val itemDao: ItemDao,
//): ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return HomeViewModel(itemDao) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}

