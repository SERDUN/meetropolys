package com.meetropolys.meetropolys.ui.screen.authorization.sign_in

import android.support.design.widget.TextInputEditText
import android.view.View
import android.widget.FrameLayout
import com.jakewharton.rxbinding2.view.RxView
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.services.message.SystemMessage
import com.meetropolys.meetropolys.ui.base.BaseActivity
import com.meetropolys.meetropolys.ui.base.mvp.SocialView
import io.reactivex.Observable


class SignInView(var view: View, var activity: BaseActivity, var systemMessage: SystemMessage) : SocialView(activity),
    SignInContract.View {
    override fun onSignInAccount(): Observable<Any> {
        return RxView.clicks(view.findViewById(R.id.create_acc_btn))

    }

    override fun getUserPassword(): Observable<CharSequence> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserEmail(): Observable<CharSequence> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserPasswordText(): String {
        return view.findViewById<TextInputEditText>(R.id.pass_tie).text.toString()
    }

    override fun getUserEmailText(): String {
        return view.findViewById<TextInputEditText>(R.id.email_tie).text.toString()
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
