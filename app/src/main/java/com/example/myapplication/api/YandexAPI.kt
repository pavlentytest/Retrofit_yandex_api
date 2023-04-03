package com.example.myapplication.api

import com.example.myapplication.model.Answer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YandexAPI {

    // https://predictor.yandex.net/api/v1/predict.json/complete
    // ?
    // key=pdct.1.1.20220412T145449Z.ed53b660ddacdc8e.353ee4c0c5adc174b6be636450d97faa6e34a072
    // q=hello+wo
    // lang=en
    // limit=5
    @GET("/api/v1/predict.json/complete")
    fun complete(@Query("key") key: String,
                 @Query("q") q: String,
                 @Query("lang") lang: String,
                 @Query("limit") limit: Int) : Call<Answer>
}