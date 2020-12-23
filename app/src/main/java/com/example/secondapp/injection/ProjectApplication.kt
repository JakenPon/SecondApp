package com.example.secondapp.injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class ProjectApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidContext(this@ProjectApplication)
            modules(presentationModule, dataModule, domainModule)
        }
    }
}