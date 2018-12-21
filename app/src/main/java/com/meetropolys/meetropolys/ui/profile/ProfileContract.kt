package com.meetropolys.meetropolys.ui.profile

import com.meetropolys.meetropolys.ui.base.BaseView
import io.reactivex.Observable

interface ProfileContract {
    interface View : BaseView {


    }

    interface Presenter {
        fun resume()
        fun pause()
    }
}
