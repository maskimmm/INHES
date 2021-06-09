package com.example.inhes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inhes.databinding.ActivitySelfDiagnoseBinding

class SelfDiagnose : AppCompatActivity() {

    private lateinit var binding: ActivitySelfDiagnoseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelfDiagnoseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setTitle("Self Diagnose")

        binding.btnCovidTest.setOnClickListener {
            val intent = Intent(this, SelfDiagnose2::class.java)
            startActivity(intent)

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}