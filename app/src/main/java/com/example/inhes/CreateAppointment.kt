package com.example.inhes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.inhes.databinding.ActivityCreateAppointmentBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CreateAppointment : AppCompatActivity() {

    private lateinit var binding: ActivityCreateAppointmentBinding
    private lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ref = FirebaseDatabase.getInstance().getReference("Appointments")

        binding.btnCreateAppointment.setOnClickListener {
            saveAppointmentData()
            val intent = Intent(this, Appointment::class.java)
            startActivity(intent)

        }

    }

    private fun saveAppointmentData(){

        val place = binding.etAddPlace.text.toString()
        val date = binding.etAddDate.text.toString()
        val time = binding.etAddTime.text.toString()

        val user = Appointments(place,date,time)
        val userId = ref.push().key.toString() //key can be changed to relative faskes's queue number

        ref.child(userId).setValue(user).addOnCompleteListener {
            Toast.makeText(this, "Appointment Created",Toast.LENGTH_SHORT).show()
        }
    }
}