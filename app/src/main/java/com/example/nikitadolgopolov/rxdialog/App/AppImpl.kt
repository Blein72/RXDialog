package com.example.nikitadolgopolov.rxdialog.App

import android.app.Application
import com.example.nikitadolgopolov.rxdialog.App.di.AppComponent
import com.example.nikitadolgopolov.rxdialog.App.di.AppModule
import com.example.nikitadolgopolov.rxdialog.App.di.DaggerAppComponent

/**
 * Created by nikita.dolgopolov
 * on 02/11/2017.
 */
class AppImpl:Application(),App {

    override fun getAppComponent(): AppComponent = component

    private val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()


    }

}