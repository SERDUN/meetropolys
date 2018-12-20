package com.meetropolys.meetropolys.ui.screen.authorization.sign_in

import android.content.Context
import android.support.v4.widget.TextViewCompat
import android.view.TextureView
import android.view.View
import android.widget.TextView
import com.jakewharton.rxbinding2.view.RxView
import com.meetropolys.meetropolys.MeetroopolysApplication
import com.meetropolys.meetropolys.R
import io.reactivex.Observable


class SignInView(var view: View, var context:Context) : SignInContract.View {

//    var googleSignInView=view.findViewById<TextView>(R.id.sign_in_google_tv)
//    var facebookSignInView=view.findViewById<TextView>(R.id.sign_in_facebook_tv)


    init {
        initView()
    }


    override fun onGoogleLoginAction(): Observable<Any> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFacebookLoginAction(): Observable<Any> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress(isVisible: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




    private fun initView() {

    }


}
