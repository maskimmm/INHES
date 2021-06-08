package com.example.inhes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase

class ActiveListAppointmentAdapter(private val listHero: ArrayList<Appointments>):
    RecyclerView.Adapter<ActiveListAppointmentAdapter.ListViewHolder>(){

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var place: TextView = itemView.findViewById(R.id.subplace)
        var date: TextView = itemView.findViewById(R.id.subdate)
        var time: TextView = itemView.findViewById(R.id.subqueue)
        val delete: Button = itemView.findViewById(R.id.btnCancel)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_appointment2, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val dummy = listHero[position]
        holder.place.text = dummy.place
        holder.date.text = dummy.date
        holder.time.text = dummy.time
        holder.delete.setOnClickListener {
        }
    }


    override fun getItemCount(): Int {
        return listHero.size
    }

}

