package com.example.nikitadolgopolov.rxdialog.timer_screen.dialog

import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nikitadolgopolov.rxdialog.R
import kotlinx.android.synthetic.main.dialog_complete_timer.*

/**
 * Created by nikita.dolgopolov
 * on 06/11/2017.
 */
class TimerDialog: DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance=true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): =
            inflater.inflate(R.layout.dialog_complete_timer, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonOk.setOnClickListener({})
    }
}