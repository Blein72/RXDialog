package com.example.nikitadolgopolov.rxdialog.timer_screen

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nikitadolgopolov.rxdialog.R
import com.example.nikitadolgopolov.rxdialog.timer_screen.dialog.TimerDialog
import kotlinx.android.synthetic.main.fragment_timer.*
import javax.inject.Inject





/**
 * Created by nikita.dolgopolov
 * on 02/11/2017.
 */
class TimerScreenFragment: Fragment(),TimerFragmentView {

    companion object {
        val DIALOG_CLOSE_CODE=0
    }

    private val DIALOG_TAG="TIMER_DIALOG_TAG"
    private lateinit var dialog:TimerDialog

    @Inject lateinit var presenter: TimerPresenter

    override fun showCompleteDialog() {
        dialog.show(activity.fragmentManager,DIALOG_TAG)
    }

    fun setupComponent() {
        (activity as TimerFragmentInjector).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance=true

        setupComponent()

        setupDialog()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_timer, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        timerButton.setOnClickListener(View.OnClickListener { presenter.startTimer() })
    }

    private fun setupDialog() {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Your time is up")
                .setTitle("Timer")
        builder.setPositiveButton("Finish", DialogInterface.OnClickListener { dialog, id ->
           presenter.closeDialog()
            // User clicked OK button
        })
        dialog = TimerDialog()
        dialog.setTargetFragment(this,DIALOG_CLOSE_CODE)
    }

    override fun onPause() {
        super.onPause()
        dialog.dismiss()
    }

    override fun closeDialog() {
        dialog.dismiss()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==TimerScreenFragment.DIALOG_CLOSE_CODE) {
            presenter.closeDialog()
        }
    }
}