package com.example.nikitadolgopolov.rxdialog.timer_screen.di

import com.example.nikitadolgopolov.rxdialog.di.FragmentScope
import com.example.nikitadolgopolov.rxdialog.timer_screen.TimerScreenFragment
import dagger.Subcomponent

/**
 * Created by nikita.dolgopolov
 * on 02/11/2017.
 */
@FragmentScope
@Subcomponent(modules = arrayOf(TimerScreenModule::class))
interface TimerScreenComponent {
    fun inject(fragment: TimerScreenFragment)
}