package com.meetropolys.meetropolys.ui.screen.authorization.confirm_email

import android.annotation.SuppressLint
import com.meetropolys.meetropolys.MeetropolysApplication
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.services.navigation.NavigationController

class ConfirmEmailPresenter(
    var view: ConfirmEmailContract.View, var navigationController: NavigationController
) : ConfirmEmailContract.Presenter {
    override fun pause() {
    }


    @SuppressLint("CheckResult")
    override fun resume() {
        view.onBackAction().subscribe { view.closeScreen() }
        view.onSendAgain()
            .subscribe {
                view.showToast(MeetropolysApplication.instance.getString(R.string.text_email_send))
                view.closeScreen()
            }
    }
}
