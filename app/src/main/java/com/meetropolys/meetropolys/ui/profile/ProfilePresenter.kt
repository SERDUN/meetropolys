package com.meetropolys.meetropolys.ui.profile

import android.annotation.SuppressLint
import com.meetropolys.meetropolys.services.Constants
import com.meetropolys.meetropolys.services.navigation.NavigationController
import com.meetropolys.meetropolys.services.navigation.Screen
import com.meetropolys.meetropolys.services.navigation.ScreenType
import com.orhanobut.hawk.Hawk

class ProfilePresenter(
    var view: ProfileContract.View,
    var navigationController: NavigationController
) : ProfileContract.Presenter {
    override fun pause() {
    }


    @SuppressLint("CheckResult")
    override fun resume() {

    }
}
