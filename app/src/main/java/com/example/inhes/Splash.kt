package com.example.inhes

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class Splash : AppCompatActivity() {

    private val splashTimeOut:Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        this.supportActionBar?.hide()

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this,Login::class.java))

            // close this activity
            finish()
        }, splashTimeOut)
    }
}