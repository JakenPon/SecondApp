package com.example.secondapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    val text: MutableLiveData<String> = MutableLiveData()

    init {
         text.value = "Texte LiveData"
    }
}