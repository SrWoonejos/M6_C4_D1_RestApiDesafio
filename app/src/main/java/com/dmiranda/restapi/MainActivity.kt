package com.dmiranda.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    val call = RetrofitClient.api.getUsers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(ArrayList())
        recyclerView.adapter = userAdapter

        loadApiData()
    }

    private fun loadApiData() {
        val api = RetrofitClient.getClient().create(Api::class.java)
        val call = api.getUsers()

        call.enqueue(object : Callback<List<User>>)  {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    userAdapter = UserAdapter(users ?: emptyList())
                    recyclerView.adapter = userAdapter
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }
        }
    }
}