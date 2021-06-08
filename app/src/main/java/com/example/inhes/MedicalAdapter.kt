package com.example.inhes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


    class MedicalAdapter(private val listHero: ArrayList<MedicalDummies>):
        RecyclerView.Adapter<MedicalAdapter.ListViewHolder>(){

        private lateinit var onItemClickCallback: OnItemClickCallback

        fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback
        }

        inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var name: TextView = itemView.findViewById(R.id.tvTitle)
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
            val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_medical_knowledge, viewGroup, false)
            return ListViewHolder(view)
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            val dummy = listHero[position]
            holder.name.text = dummy.name
//            holder.tvName.text = dummy.about
//            holder.tvDetail.text = dummy.cause
//            holder.tvName.text = dummy.precaution
//            holder.tvDetail.text = dummy.symptoms

            holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHero[holder.adapterPosition]) }
        }


        override fun getItemCount(): Int {
            return listHero.size
        }


        interface OnItemClickCallback {
            fun onItemClicked(data: MedicalDummies)
        }

    }

