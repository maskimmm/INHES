package com.project.symptomscovid19

import com.example.inhes.PredictionObject
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

//    @Headers("Content-Type: application/json")
//    @POST(".")
//    fun predictCovid19(@Body predictionInput : PredictionObject): Call<String>

    // breathing_problem={breathing_problem}&fever={fever}&dry_cough={dry_cough}&sore_throat={sore_throat}&running_nose={running_nose}&asthma={asthma}&chronic_lung_disease={chronic_lung_disease}&headache={headache}&heart_disease={heart_disease}&diabetes={diabetes}&hyper_tension={hyper_tension}&fatigue={fatigue}&gastrointestinal={gastrointestinal}
    @POST("api_predict_covid?")
    fun predictCovid19s(
        @Query("breathing_problem")  breathing_problem:Int,
        @Query("fever")  fever:Int,
        @Query("dry_cough")  dry_cough:Int,
        @Query("sore_throat")  sore_throat:Int,
        @Query("running_nose")  running_nose:Int,
        @Query("asthma")  asthma:Int,
        @Query("chronic_lung_disease")  chronic_lung_disease:Int,
        @Query("headache")  headache:Int,
        @Query("heart_disease")  heart_disease:Int,
        @Query("diabetes")  diabetes:Int,
        @Query("hyper_tension")  hyper_tension:Int,
        @Query("fatigue")  fatigue:Int,
        @Query("gastrointestinal")  gastrointestinal:Int
    ): Call<PredictionObject>

//    @POST(".")
//    fun predictSystem(@Body requestBody: RequestBody): Call<String>

}