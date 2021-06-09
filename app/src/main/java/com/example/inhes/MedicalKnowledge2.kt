package com.example.inhes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MedicalKnowledge2 : AppCompatActivity() {companion object {
    const val EXTRA_NAME = ""
    const val EXTRA_ABOUT = ""
    const val EXTRA_CAUSE = ""
    const val EXTRA_PRECAUSE = ""
    const val EXTRA_SYMPTOMS = ""
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medical_knowledge2)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setTitle("Medical Knowledge")

        val tvNameReceived: TextView = findViewById(R.id.tvAbout2)
        val tvAboutReceived: TextView = findViewById(R.id.tvSubAbout)
        val tvCauseReceived: TextView = findViewById(R.id.tvSubCauses)
        val tvPrecautionReceived: TextView = findViewById(R.id.tvSubPrecauses)
        val tvSymptomsReceived: TextView = findViewById(R.id.tvSubSymptoms)


        val name = intent.getStringExtra(EXTRA_NAME)
        val about = intent.getStringExtra(EXTRA_ABOUT)
        val cause = intent.getStringExtra(EXTRA_CAUSE)
        val precause = intent.getStringExtra(EXTRA_PRECAUSE)
        val symptoms = intent.getStringExtra(EXTRA_SYMPTOMS)

        tvNameReceived.text = name
        tvAboutReceived.text = about
        tvCauseReceived.text = cause
        tvPrecautionReceived.text = precause
        tvSymptomsReceived.text = symptoms
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}