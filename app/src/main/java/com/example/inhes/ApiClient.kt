package com.project.symptomscovid19

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

    private const val
            BASE_URL = "https://us-east1-project-bangkit-health.cloudfunctions.net/"

//    var client: OkHttpClient = OkHttpClient.Builder()
//        .connectTimeout(1, TimeUnit.MINUTES)
//        .readTimeout(60, TimeUnit.SECONDS)
//        .writeTimeout(60, TimeUnit.SECONDS)
//        .build()

//    var gson : Gson = GsonBuilder()
//        .setLenient().create()

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(Api::class.java)
    }


}