package com.example.davaleba5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log

class person : AppCompatActivity() {
    private lateinit var userInFoTextView: TextView
    private lateinit var passwordChangeButton:Button
    private lateinit var logOutButton:Button
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)


        userInFoTextView = findViewById(R.id.userInfoTextView)
        passwordChangeButton = findViewById(R.id.goToPasswordChangeButton)
        logOutButton = findViewById(R.id.logOutButton)

        userInFoTextView.text = mAuth.currentUser?.uid


        passwordChangeButton.setOnClickListener {


        }
        logOutButton.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }








    }
}