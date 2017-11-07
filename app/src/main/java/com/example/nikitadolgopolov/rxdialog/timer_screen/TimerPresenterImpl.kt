package com.example.nikitadolgopolov.rxdialog.timer_screen

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by nikita.dolgopolov
 * on 02/11/2017.
 */
class TimerPresenterImpl @Inject
    constructor(private val view:TimerFragmentView) :TimerPresenter{

    private var isDialogShown:Boolean = false

    override fun startTimer() {
        Observable.just(String)
                .subscribeOn(Schedulers.io())
                .delay(5000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onComplete = {showDialog()}

                )
    }

    private fun showDialog() {
        if (!isDialogShown) {
            view.showCompleteDialog()
            isDialogShown=true
        }
    }

    override fun closeDialog() {
        view.closeDialog()
        isDialogShown=false
    }
}