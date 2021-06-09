package com.example.inhes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.inhes.databinding.ActivitySelfDiagnose2Binding
import com.example.inhes.databinding.ActivitySelfDiagnoseBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.project.symptomscovid19.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SelfDiagnose2 : AppCompatActivity() {

    private lateinit var binding: ActivitySelfDiagnose2Binding
    private lateinit var ref : DatabaseReference
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
    private val question_explain = arrayOf(
            "Breathing problems are when you feel you can't get enough air, your chest feels very tight, you are breathless or you feel like you're being suffocated.",
            "A fever is a temporary increase in your body temperature, often due to an illness. Having a fever is a sign that something out of the ordinary is going on in your body.",
            "A cough is a reflex action that clears your airway of irritants and mucus. There are two types of cough: productive and nonproductive. A productive cough produces phlegm or mucus, clearing it from the lungs. A nonproductive cough, also known as a dry cough, doesn’t produce phlegm or mucus.",
            "A sore throat is pain, scratchiness or irritation of the throat that often worsens when you swallow.",
            "A runny nose is excess nasal drainage. It may be a thin clear fluid, thick mucus or something in between. The drainage may run out of your nose, down the back of your throat or both.",
            "Asthma is a condition in which your airways narrow and swell and may produce extra mucus. This can make breathing difficult and trigger coughing, a whistling sound (wheezing) when you breathe out and shortness of breath.",
            "These types of lung diseases may affect your airways, lung tissues, or circulation of blood in and out of your lungs. Here are the most common types, their causes and risk factors, and potential symptoms that may signal the need for medical attention.",
            "Headache is the symptom of pain in the face, head, or neck. It can occur as a migraine, tension-type headache, or cluster headache.",
            "he term “heart disease” refers to several types of heart conditions. The most common type of heart disease in the United States is coronary artery disease (CAD), which affects the blood flow to the heart. Decreased blood flow can cause a heart attack.",
            "Diabetes mellitus, commonly known as diabetes, is a metabolic disease that causes high blood sugar. The hormone insulin moves sugar from the blood into your cells to be stored or used for energy. With diabetes, your body either doesn’t make enough insulin or can’t effectively use the insulin it does make.",
            "Blood pressure is the force exerted by circulating blood against the walls of the body’s arteries, the major blood vessels in the body. Hypertension is when blood pressure is too high.",
            "Fatigue is a feeling of constant tiredness or weakness and can be physical, mental or a combination of both. It can affect anyone, and most adults will experience fatigue at some point in their life.",
            "Gastrointestinal diseases (abbrev. GI diseases or GI illnesses) refer to diseases involving the gastrointestinal tract, namely the oesophagus, stomach, small intestine, large intestine and rectum, and the accessory organs of digestion, the liver, gallbladder, and pancreas.")

    // Default Answer
    private var initialAnswer = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    private var numberQuestion = 0
    private lateinit var symptomsQuestion : TextView
    private lateinit var symptomsExplain : TextView
    private lateinit var answeringTrue : Button
    private lateinit var answeringFalse : Button
    private lateinit var previousQuestion : ImageView
    private lateinit var nextQuestion : ImageView
    private lateinit var numberCountQuestion : TextView

    private fun saveTestData(result: String, percent: String){
        val user = Result(result, percent)
        ref.child("Latest Result").setValue(user).addOnCompleteListener {}
    }


    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, SelfDiagnose::class.java)
        startActivity(intent)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelfDiagnose2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setTitle("COVID Test")

        ref = FirebaseDatabase.getInstance().getReference("CovidTest")

        // Declare Attribute From User
        symptomsQuestion = binding.symptomsQuestion
        symptomsExplain = binding.symptomsExplain
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
        var symptoms_question_show = "Do You experiencing "+ question_symptoms[numberQuestion] + " ?"
        symptomsQuestion.text = symptoms_question_show
    }
    private fun initialSymptomsExplainShow() {
        var symptoms_explain_question_show = question_explain[numberQuestion]
        symptomsExplain.text = symptoms_explain_question_show
    }

    private fun indexIncrement(){
        if(numberQuestion < question_symptoms.size-1){
            numberQuestion += 1
            initialSymptomsQuestionShow()
            initialSymptomsExplainShow()
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
            initialSymptomsExplainShow()
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
                saveTestData(response.body()!!.result.toString(), response.body()!!.message.toString())
                val intent = Intent(this@SelfDiagnose2, SelfDiagnose::class.java)
                startActivity(intent)
            }
            override fun onFailure(call: Call<PredictionObject>, t: Throwable) {
                Log.e("Failure Message", t.message.toString())
            }
        })


    }


}