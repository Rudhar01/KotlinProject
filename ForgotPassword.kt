package com.example.kotlinproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class ForgotPassword : AppCompatActivity() {
    lateinit var emailId : TextView
    lateinit var sendLoginLink : Button
    lateinit var cantReset : TextView
    lateinit var createAccount : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forgot_password)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        emailId=findViewById(R.id.Text2)
        sendLoginLink=findViewById(R.id.button)
        cantReset=findViewById(R.id.Text3)
        createAccount=findViewById(R.id.Text5)
        sendLoginLink.setOnClickListener {
            if (emailId.text.isEmpty()) {
                emailId.error = "Enter your email "
            } else {
                var intent = Intent(this,VerifyOTP::class.java)
                startActivity(intent)
            }
        }

            cantReset.setOnClickListener{

            }
            createAccount.setOnClickListener{
                var intent1 = Intent(this,CreateNewAccount::class.java)
                startActivity(intent1)
                this.finish()
            }

    }
}