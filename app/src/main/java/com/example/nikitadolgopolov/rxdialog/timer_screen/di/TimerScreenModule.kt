package com.example.nikitadolgopolov.rxdialog.timer_screen.di

import com.example.nikitadolgopolov.rxdialog.di.FragmentScope
import com.example.nikitadolgopolov.rxdialog.timer_screen.TimerFragmentView
import com.example.nikitadolgopolov.rxdialog.timer_screen.TimerPresenter
import com.example.nikitadolgopolov.rxdialog.timer_screen.TimerPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by nikita.dolgopolov
 * on 02/11/2017.
 */
@Module
class TimerScreenModule(private val view:TimerFragmentView) {

    @Provides
    @FragmentScope
    fun provideView(): TimerFragmentView {
        return this.view
    }

    @Provides
    @FragmentScope
    fun providePresenter(presenter: TimerPresenterImpl): TimerPresenter {
        return presenter
    }

}