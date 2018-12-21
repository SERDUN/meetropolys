package com.meetropolys.meetropolys.ui.screen.authorization.sign_up

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
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.services.Constants
import com.meetropolys.meetropolys.services.Constants.GOOGLE_AUTH_KEY
import com.meetropolys.meetropolys.services.navigation.NavigationController
import com.meetropolys.meetropolys.services.navigation.Screen
import com.meetropolys.meetropolys.services.navigation.ScreenType
import com.meetropolys.meetropolys.tools.Tools
import com.meetropolys.meetropolys.ui.base.mvp.SocialPresenter
import com.orhanobut.hawk.Hawk
import java.lang.StringBuilder

class SignUpPresenter(var view: SignUpContract.View, var navigationController: NavigationController) :
    SocialPresenter(view), SignUpContract.Presenter {

    @SuppressLint("CheckResult")
    override fun resume() {
        super.resume()
        view.onGoogleLoginAction().subscribe {
            view.googleAuth()
        }
        view.onFacebookLoginAction().subscribe {
            view.facebookAuth()

        }
        view.onCreateAccount().subscribe {
            createAccount()
        }
    }

    private fun createAccount() {
        if (isCorrectEmail() && isCorrectPassword()) {
              navigationController.navigateTo(Screen.CONFIRM_EMAIL_ACTIVITY, ScreenType.ACTIVITY)

        }

    }

    override fun pause() {
        super.pause()
    }


    override fun socialError(socialId: Int, details: String) {
        var message = StringBuilder()
        when (socialId) {
            Constants.SOCIAL_GOOGLE_ID -> {
                message.append("Google error code : ")
            }
            Constants.SOCIAL_FACEBOOK_ID -> {
                message.append("Facebook: ")
            }
        }
        message.append(details)

        view.showWarningMessage(message.toString(), 10000)
    }

    override fun successGoogleAuth(token: String, account: GoogleSignInAccount) {
        view.showWarningMessage("ds")
        //  navigationController.navigateTo(Screen.PROFILE_ACTIVITY, ScreenType.ACTIVITY)
    }

    override fun successFacebookAuth(loginResult: LoginResult) {
        navigationController.navigateTo(Screen.PROFILE_ACTIVITY, ScreenType.ACTIVITY)

    }


    private fun isCorrectPassword(): Boolean {
        val password = view.getUserPasswordText()
        if (password.isEmpty()) {
            view.showWarningMessage(
                MeetroopolysApplication.instance.getResources().getString(R.string.error_empty_password),
                10000
            )

            return false
        }
        if (password.length < 6 || password.length > 128) {
            view.showWarningMessage(
                MeetroopolysApplication.instance.getResources().getString(R.string.error_password),
                10000
            )
            return false
        }
        return true
    }

    private fun isCorrectEmail(): Boolean {
        val email = view.getUserEmailText()
        if (email.isEmpty()) {
            view.showWarningMessage(
                MeetroopolysApplication.instance.getResources().getString(R.string.error_empty_email),
                10000
            )
            return false
        }
        if (!Tools.isValidEmail(email)) {
            view.showWarningMessage(
                MeetroopolysApplication.instance.getResources().getString(R.string.error_empty_email),
                10000
            )
            return false
        }
        return true
    }
}






