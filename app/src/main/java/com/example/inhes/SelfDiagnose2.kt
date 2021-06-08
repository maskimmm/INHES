package com.example.inhes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.inhes.databinding.ActivitySelfDiagnose2Binding
import com.example.inhes.databinding.ActivitySelfDiagnoseBinding
import com.project.symptomscovid19.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SelfDiagnose2 : AppCompatActivity() {

    private lateinit var binding: ActivitySelfDiagnose2Binding
    // Symptoms Question
    private val question_symptoms = arrayOf(
            "Breathing Problem",
            "Fever",
            "Dry Cough",
            "Sore throat",
            "Running Nose",
            "Asthma",
            "Chronic Lung Disease",
            "Headache",
            "Heart Disease",
            "Diabetes",
            "Hyper Tension",
            "Fatigue",
            "Gastrointestinal")

    // Default Answer
    private var initialAnswer = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)

    private var numberQuestion = 0
    private lateinit var symptomsQuestion : TextView
    private lateinit var answeringTrue : Button
    private lateinit var answeringFalse : Button
    private lateinit var previousQuestion : ImageView
    private lateinit var nextQuestion : ImageView
    private lateinit var numberCountQuestion : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelfDiagnose2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Declare Attribute From User
        symptomsQuestion = binding.symptomsQuestion
        answeringTrue = binding.answeringTrue
        answeringFalse = binding.answeringFalse
        previousQuestion = binding.previousQuestion
        nextQuestion = binding.nextQuestion
        numberCountQuestion = binding.countQuestion
//
//        symptomsQuestion = findViewById(R.id.symptoms_question)
//        answeringTrue = findViewById(R.id.answering_true)
//        answeringFalse = findViewById(R.id.answering_false)
//        previousQuestion = findViewById(R.id.previous_question)
//        nextQuestion = findViewById(R.id.next_question)
//        numberCountQuestion = findViewById(R.id.count_question)

        // Initial All Input For Output
        answeringInputDiagnose()

    }

    private fun answeringInputDiagnose() {
        // Initial first text of question with some of bold in symptoms
        initialSymptomsQuestionShow()

        // Action for previous the Question, for user want to change input
        previousQuestion.setOnClickListener {
            indexDecrement()
            numberCountQuestion.text = (numberQuestion+1).toString() + "/13"
        }
        // Action for next the Question, for user want to forward input
        nextQuestion.setOnClickListener {
            // Assume that user if next question mean skip and maybe there is no symptoms
            initialAnswer[numberQuestion] = 1
            indexIncrement() // Index Increment (Next Question)
            numberCountQuestion.text = (numberQuestion+1).toString() + "/13"
        }
        // Action for answering every question with true/right/yes/have symptoms
        answeringTrue.setOnClickListener {
            initialAnswer[numberQuestion] = 0
            indexIncrement() // Index Increment (Next Question)
            numberCountQuestion.text = (numberQuestion+1).toString() + "/13"
        }
        // Action for answering every question with false/wrong/not/not have symptoms
        answeringFalse.setOnClickListener {
            initialAnswer[numberQuestion] = 1
            indexIncrement()
            numberCountQuestion.text = (numberQuestion+1).toString() + "/13"
        }
    }

    private fun initialSymptomsQuestionShow() {
        var symptoms_question_show = "Do You experiencing "+ question_symptoms[numberQuestion]
        symptomsQuestion.text = symptoms_question_show
    }

    private fun indexIncrement(){
        if(numberQuestion < question_symptoms.size-1){
            numberQuestion += 1
            initialSymptomsQuestionShow()
        }else{
            // Processing Self Diagnose
            processingSelfDiagnose(
                    initialAnswer[0],
                    initialAnswer[1],
                    initialAnswer[2],
                    initialAnswer[3],
                    initialAnswer[4],
                    initialAnswer[5],
                    initialAnswer[6],
                    initialAnswer[7],
                    initialAnswer[8],
                    initialAnswer[9],
                    initialAnswer[10],
                    initialAnswer[11],
                    initialAnswer[12],
            )
        }
    }

    private fun indexDecrement(){
        if(numberQuestion <= 0){
            Toast.makeText(this@SelfDiagnose2, "First Question", Toast.LENGTH_SHORT).show()
        }else{
            numberQuestion -= 1
            initialSymptomsQuestionShow()
        }
    }

    private fun processingSelfDiagnose(breathing_problem:Int,
                                       fever:Int,
                                       dry_cough:Int,
                                       sore_throat:Int,
                                       running_nose:Int,
                                       asthma:Int,
                                       chronic_lung_disease:Int,
                                       headache:Int,
                                       heart_disease:Int,
                                       diabetes:Int,
                                       hyper_tension:Int,
                                       fatigue:Int,
                                       gastrointestinal:Int) {

        // Api Declare
//        val predictionInputs = PredictionObject(breathing_problem, fever, dry_cough, sore_throat, running_nose,
//            asthma, chronic_lung_disease, headache, heart_disease, diabetes, hyper_tension, fatigue,
//            gastrointestinal)
//        ApiClient.instance.predictCovid19(predictionInputs).enqueue(object : Callback<String>{
//            override fun onResponse(call: Call<String>, response: Response<String>) {
//                Log.i("Sss", response.message()+" "+response.code()+" "+response.isSuccessful)
//                if (response.code() == 400) {
//                    Log.v("Error code 400", response.errorBody().toString())
//                }
//                Toast.makeText(this@MainActivity, response.code().toString() +" - "+response.body().toString(), Toast.LENGTH_LONG).show()
//            }
//
//            override fun onFailure(call: Call<String>, t: Throwable) {
//                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
//            }
//
//        })

        ApiClient.instance.predictCovid19s(
                breathing_problem, fever, dry_cough, sore_throat, running_nose,
                asthma, chronic_lung_disease, headache, heart_disease, diabetes, hyper_tension, fatigue,
                gastrointestinal
        ).enqueue(object : Callback<PredictionObject> {
            override fun onResponse(
                    call: Call<PredictionObject>,
                    response: Response<PredictionObject>
            ) {
                Toast.makeText(this@SelfDiagnose2, response.body()!!.result+" (Percentage : "+ response.body()!!.message+")", Toast.LENGTH_LONG).show()
            }
            override fun onFailure(call: Call<PredictionObject>, t: Throwable) {
                Log.e("Failure Message", t.message.toString())
            }
        })


    }


}