package com.meetropolys.meetropolys.ui.screen.authorization.sign_in

import android.annotation.SuppressLint
import android.support.annotation.NonNull
import android.util.Log
import android.view.View
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.GoogleAuthUtil
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.meetropolys.meetropolys.MeetroopolysApplication
import com.meetropolys.meetropolys.services.Constants
import com.meetropolys.meetropolys.services.Constants.GOOGLE_AUTH_KEY
import com.meetropolys.meetropolys.services.navigation.NavigationController
import com.meetropolys.meetropolys.services.navigation.Screen
import com.meetropolys.meetropolys.services.navigation.ScreenType
import com.meetropolys.meetropolys.ui.base.mvp.SocialPresenter
import com.orhanobut.hawk.Hawk

class SignInPresenter(var view: SignInContract.View, var navigationController: NavigationController) : SocialPresenter(view), SignInContract.Presenter {

    @SuppressLint("CheckResult")
    override fun resume() {
        super.resume()
        view.onGoogleLoginAction().subscribe {
            view.googleAuth()
        }
        view.onFacebookLoginAction().subscribe {
            view.facebookAuth()

        }
    }

    override fun pause() {
        super.pause()
    }


    override fun socialError(socialId: Int, details: String) {
        Log.d("","sdsd")

    }

    override fun successGoogleAuth(token: String, account: GoogleSignInAccount) {
        navigationController.navigateTo(Screen.PROFILE_ACTIVITY, ScreenType.ACTIVITY)
    }

    override fun successFacebookAuth(loginResult: LoginResult) {
        navigationController.navigateTo(Screen.PROFILE_ACTIVITY, ScreenType.ACTIVITY)

    }

}






