package com.example.davaleba5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var inputEmeil:EditText
    private lateinit var inputPassword:EditText
    private lateinit var loginButton:Button
    private lateinit var registrationButton:Button
    private lateinit var passwordResetButton:Button
    private lateinit var mAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser != null)
            startActivity(Intent(this,person::class.java))
            finish()

        setContentView(R.layout.activity_main)

        inputEmeil = findViewById(R.id.signInEmailEditText)
        inputPassword = findViewById(R.id.signInPasswordEditText)
        loginButton = findViewById(R.id.signInButton)
        registrationButton = findViewById(R.id.goToRegistrationButton)
        passwordResetButton = findViewById(R.id.goToResetPasswordButton)


        loginButton.setOnClickListener {
            val email = inputEmeil.text.toString()
            val password = inputPassword.text.toString()

            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(this,"empty!",Toast.LENGTH_LONG).show()
            }else{
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                    task -> if (task.isSuccessful){
                        startActivity(Intent(this,person::class.java))
                        finish()
                    }else{
                        Toast.makeText(this,"error!",Toast.LENGTH_LONG).show()
                }
                }
            }

        }
        registrationButton.setOnClickListener {
            startActivity(Intent(this,register::class.java))
        }
        passwordResetButton.setOnClickListener {
            startActivity(Intent(this,reset::class.java))
        }




    }




}