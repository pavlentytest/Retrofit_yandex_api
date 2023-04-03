package com.example.myapplication.api

import com.example.myapplication.NobelAnswer
import retrofit2.Call
import retrofit2.http.GET

interface NobelAPI {

    @GET("/2.0/nobelPrize/phy/2010")
    fun getData(): Call<List<NobelAnswer>>
}