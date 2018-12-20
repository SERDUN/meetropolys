package com.meetropolys.meetropolys.ui.screen.authorization

import com.meetropolys.meetropolys.ui.base.BaseView
import io.reactivex.Observable

interface BaseAuthorizationContract {
    interface View : BaseView {
        fun onLoginAction():Observable<Any>
        fun onRegistrationAction():Observable<Any>
        fun selectSignInItem()
        fun selectSignUpItem()

    }

    interface Presenter {
        fun resume()
        fun pause()
    }
}
