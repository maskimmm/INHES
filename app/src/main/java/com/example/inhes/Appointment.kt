package com.example.inhes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inhes.databinding.ActivityAppointmentBinding
import com.google.firebase.database.*

class Appointment : AppCompatActivity() {

    private lateinit var binding: ActivityAppointmentBinding
    private var list: ArrayList<Appointments> = arrayListOf()
    private lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setTitle("Appointment")

        showDatabase()

        binding.btnAddAppointment.setOnClickListener {
            val intent = Intent(this, CreateAppointment::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showDatabase(){
        ref = FirebaseDatabase.getInstance().getReference("Appointments")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()){
                    list.clear()
                    for (h in p0.children){
                        val user = h.getValue(Appointments::class.java)
                        list.add(user!!)
                    }
                    showRecyclerList()
                }
            }
        })
    }

    private fun showRecyclerList() {
        binding.rvAppointment2.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ActiveListAppointmentAdapter(list)
        binding.rvAppointment2.adapter = listHeroAdapter
    }
}
