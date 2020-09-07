package com.example.secondapp.injection

import com.example.secondapp.MainViewModel
import org.koin.dsl.module

val injectionModule = module {
    factory {MainViewModel()}
}
