package com.Intern.suitmediatest.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.Intern.suitmediatest.data.ApiConfig
import com.Intern.suitmediatest.data.ApiService
import com.Intern.suitmediatest.data.DataItem
import com.Intern.suitmediatest.data.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private val apiService: ApiService = ApiConfig().getApiService()

    fun getAllUsers(): LiveData<List<DataItem>> {
        val liveData = MutableLiveData<List<DataItem>>()

        apiService.getListUsers().enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    liveData.value = (response.body()?.data ?: emptyList()) as List<DataItem>?
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("Repository", "onFailure: ${t.message}")
            }
        })
        return liveData
    }
}