package com.example.inhes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inhes.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()
        auth = FirebaseAuth.getInstance()

        binding.btnExit.setOnClickListener{
            auth.signOut()
            val intent = Intent(this, Splash::class.java)
            startActivity(intent)
        }

        binding.btnAppointment.setOnClickListener{
            val intent = Intent(this, Appointment::class.java)
            startActivity(intent)
        }

        binding.btnSearchFasKes.setOnClickListener{
            val intent = Intent(this, SearchFaskes::class.java)
            startActivity(intent)
        }

        binding.btnSelfDiagnose.setOnClickListener{
            val intent = Intent(this, SelfDiagnose::class.java)
            startActivity(intent)
        }

        binding.btnMedicalKnowledge.setOnClickListener{
            val intent = Intent(this, MedicalKnowledge::class.java)
            startActivity(intent)
        }

    }
}