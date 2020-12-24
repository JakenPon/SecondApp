package com.example.secondapp.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.secondapp.R
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

  /*      register_login_button.setOnClickListener {
        if(register_login_edit.text.trim().isNotEmpty() || register_password_edit.text?.trim().isNotEmpty() ){
            Toast.makeText(this, "Login et Password OK", Toast.LENGTH_LONG).show()
        }else {
            Toast.makeText(this, "Login et Password manquants", Toast.LENGTH_LONG).show()
        }
        } */
    }
}