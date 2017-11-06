package com.example.nikitadolgopolov.rxdialog.main.di

import com.example.nikitadolgopolov.rxdialog.di.ActivityScope
import com.example.nikitadolgopolov.rxdialog.main.MainView
import dagger.Module
import dagger.Provides

/**
 * Created by nikita.dolgopolov
 * on 02/11/2017.
 */
@Module
class MainScreenModule(private val mainView: MainView, containerId: Int) {

    @Provides
    @ActivityScope
    fun provideView(): MainView {
        return this.mainView
    }
}