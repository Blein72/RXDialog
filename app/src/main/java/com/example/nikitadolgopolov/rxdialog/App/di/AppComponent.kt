package com.example.nikitadolgopolov.rxdialog.App.di

import dagger.Component
import javax.inject.Singleton

/**
 * Created by nikita.dolgopolov
 * on 02/11/2017.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    //provide repositories,commands, etc here
}