package com.example.nikitadolgopolov.rxdialog.main

import android.app.FragmentManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.nikitadolgopolov.rxdialog.App.App
import com.example.nikitadolgopolov.rxdialog.R
import com.example.nikitadolgopolov.rxdialog.main.di.DaggerMainScreenComponent
import com.example.nikitadolgopolov.rxdialog.main.di.MainScreenComponent
import com.example.nikitadolgopolov.rxdialog.main.di.MainScreenModule
import com.example.nikitadolgopolov.rxdialog.timer_screen.TimerFragmentInjector
import com.example.nikitadolgopolov.rxdialog.timer_screen.TimerScreenFragment
import com.example.nikitadolgopolov.rxdialog.timer_screen.di.TimerScreenModule

class MainActivity : AppCompatActivity()
        , TimerFragmentInjector
        , MainView {

    private val TIMER_FRAGMENT_TAG = "TIMER_FRAGMENT_TAG"
    open lateinit var component: MainScreenComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        setupComponent()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment=fragmentManager.findFragmentByTag(TIMER_FRAGMENT_TAG)
        if (fragment!=null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content, fragment, TIMER_FRAGMENT_TAG)
                    .commit()
        } else {
            setupListFragment()
        }

        //setupListFragment()

    }

    private val app: App
        get() = application as App

    fun setupComponent() {

        component = DaggerMainScreenComponent.builder()
                .appComponent((application as App).getAppComponent())
                .mainScreenModule(MainScreenModule(this,
                        R.id.content))
                .build()
        component.inject(this)
    }

    override fun inject(view: TimerScreenFragment) {
        component.plus(TimerScreenModule(view)).inject(view)
    }

    private fun setupListFragment() {
        val fragmentManager: FragmentManager = fragmentManager
        fragmentManager.beginTransaction()
                .replace(R.id.content, TimerScreenFragment(), TIMER_FRAGMENT_TAG)
                .commit()
    }

}
