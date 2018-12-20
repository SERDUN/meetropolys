package com.meetropolys.meetropolys.ui.screen.authorization.sign_in

import android.annotation.SuppressLint
import com.meetropolys.meetropolys.services.Constants
import com.meetropolys.meetropolys.services.navigation.NavigationController
import com.meetropolys.meetropolys.services.navigation.Screen
import com.meetropolys.meetropolys.services.navigation.ScreenType
import com.orhanobut.hawk.Hawk

class SignInPresenter(
    var view: SignInContract.View,
    var navigationController: NavigationController
) : SignInContract.Presenter {
    override fun pause() {
    }


    @SuppressLint("CheckResult")
    override fun resume() {
        view.onGoogleLoginAction().subscribe {

        }
        view.onFacebookLoginAction().subscribe {

        }
    }
}
