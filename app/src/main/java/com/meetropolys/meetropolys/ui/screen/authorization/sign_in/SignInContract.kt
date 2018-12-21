package com.meetropolys.meetropolys.ui.screen.authorization.sign_in

import com.meetropolys.meetropolys.ui.base.BaseActivity
import com.meetropolys.meetropolys.ui.base.BaseView
import com.meetropolys.meetropolys.ui.base.mvp.SocialContract
import com.meetropolys.meetropolys.ui.base.mvp.SocialView
import io.reactivex.Observable

interface SignInContract {
    interface View : SocialContract,BaseView{
        fun onGoogleLoginAction():Observable<Any>
        fun onFacebookLoginAction():Observable<Any>

    }

    interface Presenter {
        fun resume()
        fun pause()
    }
}
