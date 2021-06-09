package com.example.inhes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inhes.databinding.ActivityMedicalKnowledgeBinding

class MedicalKnowledge : AppCompatActivity() {

    private  lateinit var rv : RecyclerView
    private lateinit var binding: ActivityMedicalKnowledgeBinding
    private var list: ArrayList<MedicalDummies> = arrayListOf()

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.tvAbout-> {
                val moveIntent = Intent(this, MedicalKnowledge2::class.java)
                startActivity(moveIntent)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicalKnowledgeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setTitle("Medical Knowledge")

        rv = findViewById(R.id.rvMedicalKnowledge)
        rv.setHasFixedSize(true)
        list.addAll(DummyMedical.listData)
        showRecyclerList()


    }

    private fun showRecyclerList() {
        binding.rvMedicalKnowledge.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = MedicalAdapter(list)
        binding.rvMedicalKnowledge.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : MedicalAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MedicalDummies) {
                val intent = Intent(this@MedicalKnowledge,MedicalKnowledge2::class.java)

                intent.putExtra(MedicalKnowledge2.EXTRA_NAME, data.name)
                intent.putExtra(MedicalKnowledge2.EXTRA_ABOUT, data.about)
                intent.putExtra(MedicalKnowledge2.EXTRA_CAUSE, data.cause)
                intent.putExtra(MedicalKnowledge2.EXTRA_PRECAUSE, data.precaution)
                intent.putExtra(MedicalKnowledge2.EXTRA_SYMPTOMS, data.symptoms)

                startActivity(intent)
            }
        })
    }
}