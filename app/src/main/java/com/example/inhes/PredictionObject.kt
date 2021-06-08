package com.example.inhes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

data class PredictionObject(
//    @SerializedName("breathing_problem") val breathing_problem:Int?,
//    @SerializedName("fever") val fever:Int?,
//    @SerializedName("dry_cough") val dry_cough:Int?,
//    @SerializedName("sore_throat") val sore_throat:Int?,
//    @SerializedName("running_nose") val running_nose:Int?,
//    @SerializedName("asthma") val asthma:Int?,
//    @SerializedName("chronic_lung_disease") val chronic_lung_disease:Int?,
//    @SerializedName("headache") val headache:Int?,
//    @SerializedName("heart_disease") val heart_disease:Int?,
//    @SerializedName("diabetes") val diabetes:Int?,
//    @SerializedName("hyper_tension") val hyper_tension:Int?,
//    @SerializedName("fatigue") val fatigue:Int?,
//    @SerializedName("gastrointestinal") val gastrointestinal:Int?,

    @SerializedName("result")
    @Expose
    val result:String?,


    @SerializedName("message")
    @Expose
    val message:String?
)
