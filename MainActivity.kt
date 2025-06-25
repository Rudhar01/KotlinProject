package com.example.kotlinproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var name : EditText
    lateinit var email : EditText
    lateinit var password : EditText
    lateinit var button : Button
    lateinit var forgotPassword : TextView
    lateinit var signUp : TextView
    lateinit var name1 : TextView
    lateinit var email1 : TextView
    lateinit var password1 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    name=findViewById(R.id.eid)
    email=findViewById(R.id.eid1)
    password=findViewById(R.id.eid2)
    button=findViewById(R.id.butnChk)
    forgotPassword=findViewById(R.id.edForgotPassword)
    signUp=findViewById(R.id.edSignUp)
        name1=findViewById(R.id.edName)
        email1=findViewById(R.id.edEmail)
        password1=findViewById(R.id.edPassword)
    button.setOnClickListener {
        if(name.text.isEmpty()) {
          name.error = "Enter your name"
        } else if(email.text.isEmpty()) {
            email.error = ("Enter your email")
        } else if(password.text.isEmpty()) {
            password.error = ("Enter your password")
        } else {
            print("done")
            name1.text = name.text.toString()
            email1.text = email.text.toString()
            password1.text = password.text.toString()
        }
    }
        signUp.setOnClickListener{

        }
        forgotPassword.setOnClickListener{

        }

    }
}