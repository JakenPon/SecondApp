package com.example.secondapp.data.repository.response


import io.reactivex.internal.observers.DeferredScalarDisposable
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("api/character")
    fun getCharacter(
        @Query("page") ID: Int
    )

    companion object{
        operator fun invoke(): RickAndMortyApi {

            val okHttpClient = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://rickandmortyapi.com/")
              //  .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RickAndMortyApi::class.java)
        }
    }
}