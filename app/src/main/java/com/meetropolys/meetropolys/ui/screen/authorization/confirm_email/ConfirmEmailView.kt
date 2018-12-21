package com.meetropolys.meetropolys.ui.screen.authorization.confirm_email

import android.support.design.widget.TextInputEditText
import android.view.View
import android.widget.FrameLayout
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.services.message.SystemMessage
import com.meetropolys.meetropolys.tools.onMainThread
import com.meetropolys.meetropolys.ui.base.BaseActivity
import com.meetropolys.meetropolys.ui.base.mvp.SocialView
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


class ConfirmEmailView(var view: View, var activity: BaseActivity) : ConfirmEmailContract.View {
    override fun closeScreen() {
        activity.finish()
    }

    override fun onBackAction(): Observable<Any> {
        return RxView.clicks(view.findViewById(R.id.back_iv))

    }

    override fun showProgress(isVisible: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
