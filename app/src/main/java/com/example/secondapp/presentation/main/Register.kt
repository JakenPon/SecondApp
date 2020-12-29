package com.example.secondapp.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.secondapp.R
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.android.ext.android.inject

class Register : AppCompatActivity() {
    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register_login_button.setOnClickListener {
        if(register_login_edit.text.toString().trim().isNotEmpty() || register_password_edit.text.toString().trim().isNotEmpty() ){
            Toast.makeText(this, "Login et Password OK", Toast.LENGTH_LONG).show()
            mainViewModel.OnClickedRegister(register_login_edit.text.toString().trim())
           // handler.insert(user = register_login_edit.text.toString().trim())
        }else {
            Toast.makeText(this, "Login et Password manquants", Toast.LENGTH_LONG).show()
        }
        }
    }
}