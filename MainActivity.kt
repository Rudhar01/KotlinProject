package com.example.kotlinproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var button: Button
    lateinit var signIn: TextView
    lateinit var name1: TextView
    lateinit var email1: TextView
    lateinit var password1: TextView
    lateinit var confirm : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        name = findViewById(R.id.eid)
        email = findViewById(R.id.eid1)
        password = findViewById(R.id.eid2)
        button = findViewById(R.id.butnChk)
        confirm=findViewById(R.id.Confirm)
        signIn = findViewById(R.id.edSignIn)
//        name1=findViewById(R.id.edName)
//        email1=findViewById(R.id.edEmail)
//        password1=findViewById(R.id.edPassword)

        button.setOnClickListener {
            if (name.text.isEmpty()) {
                name.error = "Enter your name"
            } else if (email.text.isEmpty()) {
                email.error = ("Enter your email")
            } else if (password.text.isEmpty()) {
                password.error = ("Enter your password")
            } else if(confirm.text.isEmpty()){
                confirm.error="Enter your password again"
            }else if(!confirm.text.toString().equals(password.text.toString())){
                confirm.error = "Password doesn't match"
            }else {
                    var bundle = bundleOf("Msg" to  name.text.toString())
                    var bundle1 = bundleOf("Email" to email.text.toString())
                    var intent = Intent(this, Dashboard::class.java)
                    intent.putExtras(bundle)
                    intent.putExtras(bundle1)
//                intent.putExtra("Msg", name.text.toString())
//                intent.putExtra("Mail", email.text.toString())
                    startActivity(intent)
                    this.finish()
                }

        }
            signIn.setOnClickListener {
                var intent2 = Intent(this, SignIn::class.java)
                startActivity(intent2)
                this.finish()
            }


        }
    }

