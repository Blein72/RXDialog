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

    override fun startTimer() {
        Observable.just(String)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .delay(5000, TimeUnit.MILLISECONDS)
                .subscribeBy(
                        onComplete = {view.showCompleteDialog()}

                )
    }
}