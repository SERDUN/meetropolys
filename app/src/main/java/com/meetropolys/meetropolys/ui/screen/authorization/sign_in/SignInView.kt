package com.meetropolys.meetropolys.ui.screen.authorization.sign_in

import android.content.Context
import android.support.v4.widget.TextViewCompat
import android.view.TextureView
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.jakewharton.rxbinding2.view.RxView
import com.meetropolys.meetropolys.MeetroopolysApplication
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.services.Constants.GOOGLE_AUTH_KEY
import com.meetropolys.meetropolys.services.message.SystemMessage
import com.meetropolys.meetropolys.ui.base.BaseActivity
import com.meetropolys.meetropolys.ui.base.mvp.SocialView
import io.reactivex.Observable
import java.util.*


class SignInView(var view: View, var activity: BaseActivity, var systemMessage: SystemMessage) : SocialView(activity),
    SignInContract.View {
    override fun getUserPassword(): Observable<CharSequence> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserEmail(): Observable<CharSequence> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showWarningMessage(msg: String, time: Long) {
        systemMessage.showMessage(msg, 1000)
    }

    override fun showWarningMessage(int: Int) {
        systemMessage.showMessage("Test", 10000)
    }

    override fun showWarningMessage(int: String) {
        systemMessage.showMessage("Test", 10000)
    }

    var googleSignInView = view.findViewById<FrameLayout>(R.id.sign_in_google_tv)
    var facebookSignInView = view.findViewById<FrameLayout>(R.id.sign_in_facebook_tv)


    init {
        initView()
    }


    override fun onGoogleLoginAction(): Observable<Any> {
        return RxView.clicks(googleSignInView)
    }

    override fun onFacebookLoginAction(): Observable<Any> {
        return RxView.clicks(facebookSignInView)
    }

    override fun showProgress(isVisible: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun initView() {

    }


}
