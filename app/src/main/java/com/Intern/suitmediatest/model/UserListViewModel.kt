package com.Intern.suitmediatest.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.Intern.suitmediatest.data.DataItem

open class UserListViewModel(private val repository: Repository) : ViewModel() {

    private val _userList = MutableLiveData<List<DataItem>>()
    open val userList: LiveData<List<DataItem>> get() = _userList

    private val _selectedUserName = MutableLiveData<String>()
    val selectedUserName: LiveData<String> get() = _selectedUserName

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing: LiveData<Boolean> get() = _isRefreshing

    private var currentPage = 1
    private var isLastPage = false

    init {
        getUsers(refresh = true)
    }

    fun getUsers(refresh: Boolean = false) {
        if (refresh) {
            currentPage = 1
            isLastPage = false
            _userList.value = emptyList()
            _isRefreshing.value = true
        }

        if (isLastPage) return

        repository.getAllUsers(page = currentPage).observeForever { users ->
            _userList.value = if (refresh) {
                users
            } else {
                val currentList = _userList.value.orEmpty()
                currentList + users
            }

            if (users.isEmpty() || users.size < 10) {
                isLastPage = true
            }
            _isRefreshing.value = false
            currentPage++
        }
    }

    fun selectUser(name: String) {
        _selectedUserName.value = name
    }
}