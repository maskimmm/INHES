package com.example.inhes

object Dummy {
    private val dummyPlace = arrayOf("rumah","sakit","kota","bekasi")
    private val dummyDate = arrayOf("tanggal","bulan","tahun","hari")
    private val dummyTime = arrayOf("menit","waktu","detik","jam")

    val listData: ArrayList<Appointments>
        get() {
            val list = arrayListOf<Appointments>()
            for (position in dummyPlace.indices) {
                val dummy = Appointments()
                dummy.place = dummyPlace[position]
                dummy.date = dummyDate[position]
                dummy.time = dummyTime[position]
                list.add(dummy)
            }
            return list
        }
}