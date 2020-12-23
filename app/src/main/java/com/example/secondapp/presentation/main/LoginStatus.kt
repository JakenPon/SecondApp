package com.example.secondapp.presentation.main

sealed class LoginStatus

data class LoginSuccess(val email: String) : LoginStatus()
object  LoginError : LoginStatus()