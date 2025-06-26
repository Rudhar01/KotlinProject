package com.example.kotlinpractice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RealtiveLayout : AppCompatActivity() {
    lateinit var name : EditText
    lateinit var email : EditText
    lateinit var password : EditText
    lateinit var forgotPassword : TextView
    lateinit var signUp : Button
    lateinit var signIn : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_realtive_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        name=findViewById(R.id.edText2)
        email=findViewById(R.id.edText3)
        password=findViewById(R.id.edText4)
        forgotPassword=findViewById(R.id.edForgot)
        signUp=findViewById(R.id.edButton)
        signIn=findViewById(R.id.edText6)
        forgotPassword.setOnClickListener{

        }
        signUp.setOnClickListener{
            if(name.text.isEmpty()){
                name.error= "Enter the name"
            }else if(email.text.isEmpty()){
                email.error= "Enter the email"
            }else if(password.text.isEmpty()){
                password.error= "Enter the password"
            }else{
                print("Done")
            }
        }
        signIn.setOnClickListener{

        }
    }
}