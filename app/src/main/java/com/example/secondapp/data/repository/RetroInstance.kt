package com.example.secondapp.data.repository



import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface RetroInstance {

    companion object{
     val baseURL = "https://restcountries.eu/rest/v2/"
     fun getRetroInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}