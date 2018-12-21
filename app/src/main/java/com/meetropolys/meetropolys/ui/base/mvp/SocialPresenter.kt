package com.meetropolys.meetropolys.ui.base.mvp

import android.os.Handler
import android.support.annotation.NonNull
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
import io.reactivex.disposables.Disposable
import android.os.Looper


abstract class SocialPresenter(var socialView: SocialContract) {
    private var callbackManager = CallbackManager.Factory.create();
    private var authDispResult: Disposable? = null;
    private val GOOGLE_SCOPES = "oauth2:profile email"
    private var facebookCalback = object : FacebookCallback<LoginResult> {
        override fun onSuccess(loginResult: LoginResult) {
            successFacebookAuth(loginResult)
        }

        override fun onCancel() = Unit
        override fun onError(exception: FacebookException) {
            socialError(Constants.SOCIAL_FACEBOOK_ID, exception.localizedMessage)
        }
    }


    init {
        if (authDispResult == null) {
            onResultListener()
        } else {
            if (!authDispResult!!.isDisposed) {
                onResultListener()
            }
        }
    }

    private fun onResultListener() {
        LoginManager.getInstance().registerCallback(callbackManager, facebookCalback)
        authDispResult = socialView.onResultAuth().subscribe {
            callbackManager!!.onActivityResult(it.requestCode, it.resultCode, it.data);
            if (it.requestCode == Constants.GOOGLE_AUTH_KEY) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                handleGoogleAuth(task)
            }

        }
    }

    public open fun resume() {
    }


    public open fun pause() {
        // LoginManager.getInstance().unregisterCallback(callbackManager)
    }


    private fun handleGoogleAuth(@NonNull completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            Thread(Runnable {
                var token = GoogleAuthUtil.getToken(MeetroopolysApplication.instance, account!!.account, GOOGLE_SCOPES)
                Handler(Looper.getMainLooper()).post {
                    successGoogleAuth(token, account)
                }
            }).start()
        } catch (e: ApiException) {
            socialError(Constants.SOCIAL_GOOGLE_ID, e.localizedMessage)
        }

    }

    abstract fun socialError(socialId: Int, details: String)
    abstract fun successGoogleAuth(token: String, account: GoogleSignInAccount)
    abstract fun successFacebookAuth(loginResult: LoginResult)

}