package com.dmiranda.restapi

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import com.dmiranda.restapi.adapter.UserAdapter
import com.dmiranda.restapi.pojo.User
import com.dmiranda.restapi.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var mAdapter: UserAdapter
    lateinit var coordinatorLayout: CoordinatorLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        loadApiData()
    }

    private fun loadApiData() {
        val service = RetrofitClient.retrofitInstance()
        val call = service.getAllUsers()

        // Async
        call.enqueue(object : Callback<ArrayList<User>> {
            override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                val usersFromApi = response.body()
                if (usersFromApi != null) {
                    mAdapter = UserAdapter(usersFromApi)
                    recyclerView.adapter = mAdapter
                }
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                Log.d("MAIN", "Error: $t")
                Toast.makeText(
                    applicationContext,
                    "Error: no pudimos recuperar los usuarios desde el api",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}
