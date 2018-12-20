package com.meetropolys.meetropolys.ui.screen.authorization.sign_in

import com.meetropolys.meetropolys.ui.base.BaseView
import io.reactivex.Observable

interface SignInContract {
    interface View : BaseView {
        fun onGoogleLoginAction():Observable<Any>
        fun onFacebookLoginAction():Observable<Any>


    }

    interface Presenter {
        fun resume()
        fun pause()
    }
}
