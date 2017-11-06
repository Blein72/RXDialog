package com.example.nikitadolgopolov.rxdialog.timer_screen

import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nikitadolgopolov.rxdialog.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_timer.*
import javax.inject.Inject





/**
 * Created by nikita.dolgopolov
 * on 02/11/2017.
 */
class TimerScreenFragment: Fragment(),TimerFragmentView {

    private val onScreenDisposable = CompositeDisposable()

    private var isDialogShown:Boolean = false
    private lateinit var dialog:AlertDialog

    @Inject lateinit var presenter: TimerPresenter

    override fun showCompleteDialog() {
        if (!isDialogShown) {
            showDialog()
            isDialogShown=true
        }
    }

    fun setupComponent() {
        (activity as TimerFragmentInjector).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupComponent()

        setupDialog()
    }

    protected override fun onResume() {
        super.onResume()

        onScreenDisposable.add(
                mainViewModel.actionTrigger.observe().subscribe({ aBoolean -> showConfirmationDialog() }))
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
            isDialogShown=false
            dialog.dismiss()
            // User clicked OK button
        })
        dialog = builder.create()
    }

    private fun showDialog() {

        dialog.show().s
    }

    override fun onPause() {
        super.onPause()
        dialog.dismiss()
    }
}