package com.example.inhes

import androidx.appcompat.app.AppCompatActivity


class CovidTest : AppCompatActivity() {
//    private val question_symptoms = arrayOf(
//        "Breathing Problem",
//        "Fever",
//        "Dry Cough",
//        "Sore throat",
//        "Running Nose",
//        "Asthma",
//        "Chronic Lung Disease",
//        "Headache",
//        "Heart Disease",
//        "Diabetes",
//        "Hyper Tension",
//        "Fatigue",
//        "Gastrointestinal")
//
//    // Default Answer
//    private var initialAnswer = floatArrayOf(0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f)
//
//    private var numberQuestion = 0
//    private lateinit var symptomsQuestion : TextView
//    private lateinit var answeringTrue : Button
//    private lateinit var answeringFalse : Button
//    private lateinit var previousQuestion : ImageView
//    private lateinit var nextQuestion : ImageView
//    private lateinit var numberCountQuestion : TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // Declare Attribute From User
//        symptomsQuestion = findViewById(R.id.symptoms_question)
//        answeringTrue = findViewById(R.id.answering_true)
//        answeringFalse = findViewById(R.id.answering_false)
//        previousQuestion = findViewById(R.id.previous_question)
//        nextQuestion = findViewById(R.id.next_question)
//        numberCountQuestion = findViewById(R.id.count_question)
//
//        // Initial All Input For Output
//        answeringInputDiagnose()
//
//    }
//
//    private fun answeringInputDiagnose() {
//        // Initial first text of question with some of bold in symptoms
//        initialSymptomsQuestionShow()
//
//        // Action for previous the Question, for user want to change input
//        previousQuestion.setOnClickListener {
//            indexDecrement()
//            numberCountQuestion.text = (numberQuestion+1).toString() + "/13"
//        }
//        // Action for next the Question, for user want to forward input
//        nextQuestion.setOnClickListener {
//            // Assume that user if next question mean skip and maybe there is no symptoms
//            initialAnswer[numberQuestion] = 1.0f
//            indexIncrement() // Index Increment (Next Question)
//            numberCountQuestion.text = (numberQuestion+1).toString() + "/13"
//        }
//        // Action for answering every question with true/right/yes/have symptoms
//        answeringTrue.setOnClickListener {
//            initialAnswer[numberQuestion] = 0.0f
//            indexIncrement() // Index Increment (Next Question)
//            numberCountQuestion.text = (numberQuestion+1).toString() + "/13"
//        }
//        // Action for answering every question with false/wrong/not/not have symptoms
//        answeringFalse.setOnClickListener {
//            initialAnswer[numberQuestion] = 1.0f
//            indexIncrement()
//            numberCountQuestion.text = (numberQuestion+1).toString() + "/13"
//        }
//    }
//
//    private fun initialSymptomsQuestionShow() {
//        var symptoms_question_show = "Do You experiencing "+ question_symptoms[numberQuestion]
//        symptomsQuestion.text = symptoms_question_show
//    }
//
//    private fun indexIncrement(){
//        if(numberQuestion < question_symptoms.size-1){
//            numberQuestion += 1
//            initialSymptomsQuestionShow()
//        }else{
//            var byteBuffer : ByteBuffer = ByteBuffer.allocateDirect(4 * 13)
//            for(answer_show in initialAnswer.indices){
//                byteBuffer.putFloat(initialAnswer[answer_show])
//            }
//            // Processing Self Diagnose
//            processingSelfDiagnose(byteBuffer)
//        }
//    }
//
//    private fun indexDecrement(){
//        if(numberQuestion <= 0){
//            Toast.makeText(this@CovidTest, "First Question", Toast.LENGTH_SHORT).show()
//        }else{
//            numberQuestion -= 1
//            initialSymptomsQuestionShow()
//        }
//    }
//
//    private fun processingSelfDiagnose(byteBuffer: ByteBuffer) {
//        val model = CovidPrediction.newInstance(this@CovidTest)
//
//        // Creates inputs for reference.
//        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 13), Element.DataType.FLOAT32)
//
//        inputFeature0.loadBuffer(byteBuffer)
//
//        // Runs model inference and gets result.
//        val outputs = model.process(inputFeature0)
//        val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray
//
//        // Output for check percentages between class
//        Toast.makeText(
//            this@CovidTest,
//            "Class 0 (YES) : "+outputFeature0[0].toString()+"\n"
//                    +"Class 1 (NO) :"+outputFeature0[1].toString(),
//            Toast.LENGTH_SHORT ).show()
//
//        model.close()
//    }

}