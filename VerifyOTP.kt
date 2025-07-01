package com.example.kotlinproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged

class VerifyOTP : AppCompatActivity() {
    lateinit var num1 : EditText
    lateinit var num2 : EditText
    lateinit var num3 : EditText
    lateinit var num4 : EditText
    lateinit var verify : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_verify_otp)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        num1 = findViewById(R.id.Num1)
        num2 = findViewById(R.id.Num2)
        num3 = findViewById(R.id.Num3)
        num4 = findViewById(R.id.Num4)
        verify = findViewById(R.id.Verify)

        num1.doOnTextChanged { text, start, before, count ->
            if (text?.length == 1) {
                num2.requestFocus()
            }
        }
            num2.doOnTextChanged { text, start, before, count ->
                if (text?.length == 1) {
                    num3.requestFocus()
                }
            }
                num3.doOnTextChanged { text, start, before, count ->
                    if (text?.length == 1) {
                        num4.requestFocus()
                    }
                }

                    verify.setOnClickListener {
                        if (num1.text.isEmpty()) {
                            num1.error = "Enter the OTP"
                        } else if (num2.text.isEmpty()) {
                            num2.error = "Enter the OTP"
                        } else if (num3.text.isEmpty()) {
                            num3.error = "Enter the OTP"
                        } else if (num4.text.isEmpty()) {
                            num4.error = "Enter the OTP"
                        } else {
                            var intent = Intent(this, SignIn::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
            }

