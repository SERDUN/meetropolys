package com.meetropolys.meetropolys.ui.screen.authorization.sign_in

import android.annotation.SuppressLint
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.meetropolys.meetropolys.MeetropolysApplication
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.services.Constants
import com.meetropolys.meetropolys.services.navigation.NavigationController
import com.meetropolys.meetropolys.services.navigation.Screen
import com.meetropolys.meetropolys.services.navigation.ScreenType
import com.meetropolys.meetropolys.tools.AppHelper
import com.meetropolys.meetropolys.tools.Tools
import com.meetropolys.meetropolys.ui.base.mvp.SocialPresenter
import java.lang.StringBuilder

class SignInPresenter(var view: SignInContract.View, var navigationController: NavigationController) :
    SocialPresenter(view), SignInContract.Presenter {

    @SuppressLint("CheckResult")
    override fun resume() {
        super.resume()
        view.onGoogleLoginAction().subscribe {
            view.googleAuth()
        }
        view.onFacebookLoginAction().subscribe {
            view.facebookAuth()
        }
        view.onSignInAccount().subscribe {
            signIn()
        }
    }


    private fun signIn() {
        if (isCorrectEmail() && isCorrectPassword()) {
            var localPass = AppHelper.api.getUserPassword()
            var localEmail = AppHelper.api.getUserEmail()
            if (localEmail != view.getUserEmailText() || localPass != view.getUserPasswordText()) {
                view.showWarningMessage(
                    MeetropolysApplication.instance.getString(R.string.title_invalid_pass_or_email),
                    10000
                )
            } else {
                navigationController.navigateTo(Screen.PROFILE_ACTIVITY, ScreenType.ACTIVITY)

            }


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
                MeetropolysApplication.instance.getResources().getString(R.string.error_empty_password),
                10000
            )

            return false
        }
        if (password.length < 6 || password.length > 128) {
            view.showWarningMessage(
                MeetropolysApplication.instance.getResources().getString(R.string.error_password),
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
                MeetropolysApplication.instance.getResources().getString(R.string.error_empty_email),
                10000
            )
            return false
        }
        if (!Tools.isValidEmail(email)) {
            view.showWarningMessage(
                MeetropolysApplication.instance.getResources().getString(R.string.error_empty_email),
                10000
            )
            return false
        }
        return true
    }
}






