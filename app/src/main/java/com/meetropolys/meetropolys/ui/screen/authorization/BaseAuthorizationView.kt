package com.meetropolys.meetropolys.ui.screen.authorization

import android.view.View
import com.jakewharton.rxbinding2.view.RxView
import com.meetropolys.meetropolys.R
import io.reactivex.Observable


class BaseAuthorizationView(var view: View) : BaseAuthorizationContract.View {


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
