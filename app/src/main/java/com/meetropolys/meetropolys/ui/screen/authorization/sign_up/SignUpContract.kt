package com.meetropolys.meetropolys.ui.screen.authorization.sign_up

import com.meetropolys.meetropolys.ui.base.BaseActivity
import com.meetropolys.meetropolys.ui.base.BaseView
import com.meetropolys.meetropolys.ui.base.mvp.SocialContract
import com.meetropolys.meetropolys.ui.base.mvp.SocialView
import io.reactivex.Observable

interface SignUpContract {
    interface View : SocialContract,BaseView{
        fun onGoogleLoginAction():Observable<Any>
        fun onFacebookLoginAction():Observable<Any>
        fun onCreateAccount():Observable<Any>
        fun showWarningMessage(int: Int)
        fun showWarningMessage(int: String)
        fun showWarningMessage(int: String,time:Long)
        fun getUserPassword(): Observable<CharSequence>
        fun getUserEmail(): Observable<CharSequence>
        fun getUserPasswordText(): String
        fun getUserEmailText(): String


    }

    interface Presenter {
        fun resume()
        fun pause()
    }
}
