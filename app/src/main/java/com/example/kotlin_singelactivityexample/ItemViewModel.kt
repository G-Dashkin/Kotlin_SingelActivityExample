package com.example.kotlin_singelactivityexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {

    private val selectedItem = MutableLiveData<String>()

    fun setData(item: String){
        selectedItem.value = item
    }

    fun getSelectedItem(): LiveData<String> {
        return selectedItem
    }

}