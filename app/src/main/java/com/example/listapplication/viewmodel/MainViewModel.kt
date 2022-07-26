package com.example.listapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listapplication.data.ListDataProvider
import com.example.listapplication.model.Model
import java.util.*

class MainViewModel(val dataProvider: ListDataProvider = ListDataProvider()) : ViewModel() {

    val dataList = MutableLiveData<List<Model>>()
    init{
        var list = mutableListOf<Model>()
        list.add(Model("first", "detail"))
        list.add(Model("smith", "detail"))
        list.add(Model("joe", "detail"))
        list.add(Model("tim", "detail"))
        list.add(Model("Chris", "detail"))
        dataList.value = list
    }
}