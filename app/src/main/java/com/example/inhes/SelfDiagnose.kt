package com.example.inhes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inhes.databinding.ActivitySelfDiagnoseBinding
import com.google.firebase.database.*

class SelfDiagnose : AppCompatActivity() {

    private lateinit var binding: ActivitySelfDiagnoseBinding
    private var list: ArrayList<Result> = arrayListOf()
    private lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelfDiagnoseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setTitle("Self Diagnose")

        showDatabase()

        binding.btnCovidTest.setOnClickListener {
            val intent = Intent(this, SelfDiagnose2::class.java)
            startActivity(intent)

        }
    }



    override fun onSupportNavigateUp(): Boolean {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        return true
    }

    private fun showDatabase(){
        ref = FirebaseDatabase.getInstance().getReference("CovidTest")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {}
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()){
                    list.clear()
                    for (h in p0.children){
                        val user = h.getValue(Result::class.java)
                        list.add(user!!)
                    }
                    showRecyclerList()
                }
            }
        })
    }

    private fun showRecyclerList() {
        binding.rvResult.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = TestAdapter(list)
        binding.rvResult.adapter = listHeroAdapter
    }
}