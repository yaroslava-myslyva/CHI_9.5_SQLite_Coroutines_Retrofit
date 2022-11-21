package com.example.chi_95_sqlitecoroutinesretrofit.network

import com.example.chi_95_sqlitecoroutinesretrofit.Animal
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("/animals/rand/10/")
    fun getResponseItem(): Call<List<Animal>>
}