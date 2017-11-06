package com.example.nikitadolgopolov.rxdialog.main.di

import com.example.nikitadolgopolov.rxdialog.App.di.AppComponent
import com.example.nikitadolgopolov.rxdialog.di.ActivityScope
import com.example.nikitadolgopolov.rxdialog.main.MainActivity
import com.example.nikitadolgopolov.rxdialog.timer_screen.di.TimerScreenComponent
import com.example.nikitadolgopolov.rxdialog.timer_screen.di.TimerScreenModule
import dagger.Component

/**
 * Created by nikita.dolgopolov
 * on 02/11/2017.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(MainScreenModule::class))
interface MainScreenComponent {

    fun inject(mainActivity: MainActivity)

    fun plus(screensModule: TimerScreenModule): TimerScreenComponent
}