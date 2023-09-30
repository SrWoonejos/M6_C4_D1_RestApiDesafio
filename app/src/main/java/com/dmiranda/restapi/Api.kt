package com.dmiranda.restapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.ArrayList
import com.dmiranda.restapi.pojo.User

interface Api {
    @GET("/users")
    fun getAllUsers(): Call<ArrayList<User>>
}