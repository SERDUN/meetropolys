package com.meetropolys.meetropolys.ui.base.mvp

import com.meetropolys.meetropolys.ui.base.BaseActivity
import com.meetropolys.meetropolys.ui.base.BaseView
import io.reactivex.Observable

interface SocialContract {
        public fun googleAuth()
        public fun facebookAuth()
        public fun onResultAuth(): Observable<BaseActivity.OnActivityResult>

}
