package com.example.secondapp.injection

import android.content.Context
import androidx.room.Room
import com.example.secondapp.data.local.AppDatabase
import com.example.secondapp.data.local.DatabaseDao
import com.example.secondapp.data.repository.UserRepository
import com.example.secondapp.domain.usecase.CreateUserUseCase
import com.example.secondapp.domain.usecase.GetUserUseCase
import com.example.secondapp.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel(get(),get()) }
}

val domainModule = module {
   factory { CreateUserUseCase(get()) }
   factory { GetUserUseCase(get()) }
}

val dataModule = module{
   single { UserRepository(get())}
   single { createDatabase(androidContext())}
}

fun createDatabase(context: Context): DatabaseDao{
    val appDatabase = Room.databaseBuilder(
    context,
    AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}