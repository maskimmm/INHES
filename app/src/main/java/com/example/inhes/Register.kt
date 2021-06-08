package com.example.inhes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.inhes.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()
        auth = FirebaseAuth.getInstance()

        binding.tvSignIn.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.btnRegist.setOnClickListener{
            if(binding.etEmail.text.trim().toString().isNotEmpty() || binding.etPassword.text.trim().toString().isNotEmpty())
            {
                val pattern = "@".toRegex()
                if(binding.etEmail.text.trim().toString().contains(pattern)){
                    if(binding.etPassword.text.trim().toString() == binding.etPassword2.text.trim().toString()){
                        if(binding.etPassword.text.trim().toString().length > 8 ){
                            createUser(binding.etEmail.text.trim().toString(), binding.etPassword.text.trim().toString())
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, "Password must be atleast 9 characters", Toast.LENGTH_LONG).show()
                        }
                    }else{
                        Toast.makeText(this, "Password and Confirm Password must be the same", Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this, "Please Provide a valid email", Toast.LENGTH_LONG).show()
                }
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

    private fun createUser(email:String, password:String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){ task ->
            if(task.isSuccessful)
            {
                Toast.makeText(this, "Register Successful", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Please Provide Inputs Correctly", Toast.LENGTH_LONG).show()
            }
        }
    }
}