package com.example.testapp.network

import com.example.testapp.model.Beer
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("v2/beers")
    fun getBeers(@Query("page") page: Int
                 , @Query("per_page") size: Int): Call<List<Beer>>
}