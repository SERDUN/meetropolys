package com.meetropolys.meetropolys.ui.screen.authorization

import android.content.Context
import android.support.v4.widget.TextViewCompat
import android.view.View
import android.widget.TextView
import com.jakewharton.rxbinding2.view.RxView
import com.meetropolys.meetropolys.R
import io.reactivex.Observable


class BaseAuthorizationView(var view: View, var context:Context) : BaseAuthorizationContract.View {
    var signInView=view.findViewById<TextView>(R.id.login_tv)
    var signUpView=view.findViewById<TextView>(R.id.registration_tv)


    init {
        initView()
    }

    private fun initView() {

    }

    override fun selectSignUpItem() {
        TextViewCompat.setTextAppearance(signUpView, R.style.selected_title_text_style)
        TextViewCompat.setTextAppearance(signInView, R.style.title_text_style)

    }

    override fun selectSignInItem() {
        TextViewCompat.setTextAppearance(signUpView, R.style.title_text_style)
        TextViewCompat.setTextAppearance(signInView, R.style.selected_title_text_style)

           }


    override fun onLoginAction(): Observable<Any> {
        return RxView.clicks(view.findViewById(R.id.login_tv))
    }

    override fun onRegistrationAction(): Observable<Any> {
        return RxView.clicks(view.findViewById(R.id.registration_tv))
    }

    override fun showProgress(isVisible: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
