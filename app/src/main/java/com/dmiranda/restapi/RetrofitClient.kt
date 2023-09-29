package com.dmiranda.restapi

class RetrofitClient {

    private var retrofit: Retrofit? = null

    class Retrofit {

    }

    private val BASE_URL = ""

    fun getClient(): Retrofit  {
        if (retrofit == null)  {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit as Retrofit
    }

    class GsonConverterFactory {
        companion object {
            fun create(): Any {
            }
        }

    }

    companion object {
        fun getClient(): Any {
        }
    }

}
