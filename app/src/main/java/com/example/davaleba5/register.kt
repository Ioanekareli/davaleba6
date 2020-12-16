package com.example.davaleba5

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class register : AppCompatActivity() {

    private lateinit var inputEmail:EditText
    private lateinit var inputPassword:EditText
    private lateinit var registrationButtton:Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        inputEmail = findViewById(R.id.signUpEmailEditText)
        inputPassword = findViewById(R.id.signInPasswordEditText)
        registrationButtton = findViewById(R.id.signUpRegistrationButton)

        registrationButtton.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(this,"empty",Toast.LENGTH_LONG).show()
            }else{
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                    task -> if (task.isSuccessful){
                        startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(this,"error!",Toast.LENGTH_LONG).show()
                }
                }
            }

        }








    }
}