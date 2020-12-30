package com.example.secondapp.data.repository


import com.example.secondapp.data.repository.response.CountriesItem
import com.example.secondapp.data.repository.response.CountriesList

import retrofit2.Call
import retrofit2.http.GET


interface RetroService {
     @GET("all/")
        fun getCountries() :Call<List<CountriesItem>>

}
