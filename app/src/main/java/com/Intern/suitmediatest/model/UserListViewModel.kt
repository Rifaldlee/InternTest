package com.Intern.suitmediatest.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.Intern.suitmediatest.data.DataItem

open class UserListViewModel(private val repository: Repository) : ViewModel() {

    private val _userList = MutableLiveData<List<DataItem>>()
    open val userList: LiveData<List<DataItem>> get() = _userList

    fun getUsers() {
        repository.getAllUsers().observeForever {
            _userList.value = it
        }
    }
}