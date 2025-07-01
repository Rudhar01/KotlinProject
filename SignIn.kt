package com.example.kotlinproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignIn : AppCompatActivity() {
    lateinit var  name : TextView
    lateinit var pass : TextView
    lateinit var button : Button
    lateinit var forgot : TextView
    lateinit var Sign : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        name=findViewById(R.id.EnterName)
        pass=findViewById(R.id.EnterPass)
        button=findViewById(R.id.ButtonIn)
        forgot=findViewById(R.id.Forgot)
        Sign=findViewById(R.id.sign)
        Sign.setOnClickListener{
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        button.setOnClickListener{

        }
        forgot.setOnClickListener {
            var intent1 = Intent(this, ForgotPassword::class.java)
            startActivity(intent1)
            this.finish()
        }
    }
}