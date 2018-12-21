package com.meetropolys.meetropolys.ui.screen.authorization.confirm_email

import com.meetropolys.meetropolys.ui.base.BaseView
import io.reactivex.Observable

interface ConfirmEmailContract {
    interface View : BaseView {
        fun onBackAction():Observable<Any>
        fun closeScreen()
        fun onSendAgain():Observable<Any>
        fun showToast(string: String)

    }

    interface Presenter {
        fun resume()
        fun pause()
    }
}
