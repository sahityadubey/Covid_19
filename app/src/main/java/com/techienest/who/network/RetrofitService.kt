package com.techienest.who.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.techienest.who.constants.StringConstant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitService {
    private val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)) .build()

    var gson = GsonBuilder()
        .setLenient()
        .create()

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(StringConstant().baseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build().create(IGetDataAPI::class.java)
    }
}