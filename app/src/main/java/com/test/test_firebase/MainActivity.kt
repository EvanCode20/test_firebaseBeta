package com.test.test_firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtUsername = findViewById<EditText>(R.id.etUsername)
        val pwPassword = findViewById<EditText>(R.id.etPassword)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)

        val btnPref = findViewById<Button>(R.id.btnPref)
        //this is a comment that will go in testpr branch


        auth = Firebase.auth

        btnSignUp.setOnClickListener{
            val inputUsername = txtUsername.text.toString()
            val inputPassword = pwPassword.text.toString()
            auth.createUserWithEmailAndPassword(inputUsername, inputPassword)
                .addOnCompleteListener(this)
                { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
                    }
                }
                .addOnFailureListener(this)
                {
                    exception ->
                    Toast.makeText(this,exception.message, Toast.LENGTH_LONG).show()
                }

        }

        btnPref.setOnClickListener{
            val intent = Intent(this, PreferencesActivity::class.java)
            startActivity(intent)
        }













    }



}