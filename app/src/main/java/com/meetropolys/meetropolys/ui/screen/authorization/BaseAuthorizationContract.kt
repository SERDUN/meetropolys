package com.meetropolys.meetropolys.ui.screen.authorization

import com.meetropolys.meetropolys.ui.base.BaseView

interface BaseAuthorizationContract {
    interface View : BaseView

    interface Presenter {
        fun resume()
    }
}
