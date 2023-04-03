package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.example.myapplication.api.YandexAPI
import com.example.myapplication.model.Answer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById<EditText>(R.id.editText)

    }

    fun doRequest(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://predictor.yandex.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val key = "pdct.1.1.20220412T145449Z.ed53b660ddacdc8e.353ee4c0c5adc174b6be636450d97faa6e34a072"
        val limit = 5
        val api: YandexAPI = retrofit.create(YandexAPI::class.java)
        api.complete(key, editText.text.toString(), "en", limit).enqueue(object: Callback<Answer>{
            override fun onResponse(call: Call<Answer>, response: Response<Answer>) {
                Log.d("RRR",response.code().toString())
            }
            override fun onFailure(call: Call<Answer>, t: Throwable) {
                Log.d("RRR",t.toString())
            }

        })

    }
}