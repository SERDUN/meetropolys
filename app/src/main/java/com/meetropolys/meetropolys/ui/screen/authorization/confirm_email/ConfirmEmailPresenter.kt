package com.meetropolys.meetropolys.ui.screen.authorization.confirm_email

import android.annotation.SuppressLint
import com.meetropolys.meetropolys.services.Constants
import com.meetropolys.meetropolys.services.navigation.NavigationController
import com.meetropolys.meetropolys.services.navigation.Screen
import com.meetropolys.meetropolys.services.navigation.ScreenType
import com.orhanobut.hawk.Hawk

class ConfirmEmailPresenter(
    var view: ConfirmEmailContract.View,
    var navigationController: NavigationController
) : ConfirmEmailContract.Presenter {
    override fun pause() {
    }


    @SuppressLint("CheckResult")
    override fun resume() {
        view.onBackAction().subscribe { view.closeScreen() }

    }
}
