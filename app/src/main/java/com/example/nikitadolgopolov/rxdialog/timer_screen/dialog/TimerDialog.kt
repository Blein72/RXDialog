package com.example.nikitadolgopolov.rxdialog.timer_screen.dialog

import android.app.Dialog
import android.app.DialogFragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nikitadolgopolov.rxdialog.R
import com.example.nikitadolgopolov.rxdialog.timer_screen.TimerScreenFragment
import kotlinx.android.synthetic.main.dialog_complete_timer.*

/**
 * Created by nikita.dolgopolov
 * on 06/11/2017.
 */
class TimerDialog : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
            super.onCreateDialog(savedInstanceState)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dialog_complete_timer, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonOk.setOnClickListener(
                {
                    sendResult()
                    dismiss()
                })
    }

    private fun sendResult() {
        val intent = Intent()
        targetFragment.onActivityResult(targetRequestCode,TimerScreenFragment.DIALOG_CLOSE_CODE,intent)
    }

    override fun onDestroyView() {
        if (dialog != null && retainInstance) {
            dialog.setDismissMessage(null)
        }
        super.onDestroyView()
    }


}