package com.example.nikitadolgopolov.rxdialog.App.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.nikitadolgopolov.rxdialog.App.AppImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by nikita.dolgopolov
 * on 02/11/2017.
 */
@Module
class AppModule(app: AppImpl) {
    private val app: Application

    init {
        this.app = app
    }

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideContext(): Context = app.applicationContext


    @Provides
    @Singleton
    fun providesSharedPreferences(): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(app)
}