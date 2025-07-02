package com.example.kotlinproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinproject.databinding.ActivityAlertDialogBinding
import com.google.android.material.snackbar.Snackbar

class AlertDialog : AppCompatActivity() {
    var a =1
    lateinit var binding : ActivityAlertDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAlertDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.BtnToast.setOnClickListener {
            Toast.makeText(this,"This ia an alert", Toast.LENGTH_SHORT).show()
        }
        binding.BtnSnack.setOnClickListener {
            Snackbar.make(binding.BtnSnack, "This is SnackBar" , Snackbar.LENGTH_INDEFINITE)
                .setAction("Ok"){

                }
                .show()
        }
        binding.BtnAlert.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Alert!")
                .setMessage("What do you want to do")
                .setPositiveButton("Add") {_,_ ->
                    a+=1
                    binding.Text.text = a.toString()
                }
                .setNegativeButton("Sub") {_,_ ->
                    a-=1
                    binding.Text.text = a.toString()
                }
                .setNeutralButton("Zero"){_,_ ->
                    a=0
                    binding.Text.text = a.toString()
                }
                .show()
        }

    }
}