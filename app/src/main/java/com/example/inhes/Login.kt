package com.example.inhes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.inhes.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()
        auth = FirebaseAuth.getInstance()


        binding.tvCreateOne.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener{
            if(binding.etEmail.text.trim().toString().isNotEmpty() || binding.etPassword.text.trim().toString().isNotEmpty())
            {
                signInUser(binding.etEmail.text.trim().toString(), binding.etPassword.text.trim().toString())
            }else{
                Toast.makeText(this, "Please Type in Email and Password", Toast.LENGTH_LONG).show()
            }
        }
    }

    //check whether user already logged in or not
    override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        if(user != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun signInUser(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){task ->
                    if(task.isSuccessful)
                    {
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Incorrect Password", Toast.LENGTH_LONG).show()
                    }
                }
    }


}