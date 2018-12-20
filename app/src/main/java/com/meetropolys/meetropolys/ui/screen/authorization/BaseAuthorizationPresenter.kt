package com.meetropolys.meetropolys.ui.screen.authorization

import android.annotation.SuppressLint
import com.meetropolys.meetropolys.services.navigation.NavigationController
import com.meetropolys.meetropolys.services.navigation.Screen
import com.meetropolys.meetropolys.services.navigation.ScreenType

class BaseAuthorizationPresenter(
    var view: BaseAuthorizationContract.View,
    var navigationController: NavigationController
) : BaseAuthorizationContract.Presenter {
    override fun pause() {
    }


    @SuppressLint("CheckResult")
    override fun resume() {
        view.onLoginAction().subscribe {
            navigationController.navigateTo(Screen.SIGN_IN_FRAGMENT, ScreenType.FRAGMENT)
        }
        view.onRegistrationAction().subscribe {
            navigationController.navigateTo(Screen.SIGN_UP_FRAGMENT, ScreenType.FRAGMENT)
        }
    }
}
