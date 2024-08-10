package com.Intern.suitmediatest.data

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getListUsers(): Call<UserResponse>
}