package com.example.secondapp.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.secondapp.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess ->{
                    val intent = Intent(this,List_view::class.java)
                    startActivity(intent)
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("Compte inconnu")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss() }
                        .show()
                }
            }
        })
        login_button.setOnClickListener {
            if(login_edit.text.toString().trim().isNotEmpty() || password_edit.text.toString().trim().isNotEmpty() ){
                mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
            }else {
                Toast.makeText(this, "Login et Password manquants", Toast.LENGTH_LONG).show()
            }

        }
        create_account_button.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}
