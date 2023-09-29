package com.dmiranda.restapi

import android.telecom.Call
import retrofit2.http.GET


interface Api {
    @GET("users")
    fun getUsers(): Call<List<User>>

    annotation class GET(val value: String)
}