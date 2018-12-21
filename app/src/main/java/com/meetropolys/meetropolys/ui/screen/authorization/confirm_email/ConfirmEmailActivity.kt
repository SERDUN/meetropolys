package com.meetropolys.meetropolys.ui.screen.authorization.confirm_email

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.tools.SystemUtils
import com.meetropolys.meetropolys.ui.base.BaseActivity
import com.meetropolys.meetropolys.ui.screen.authorization.BaseAuthorizationPresenter
import com.meetropolys.meetropolys.ui.screen.authorization.BaseAuthorizationView

class ConfirmEmailActivity : BaseActivity() {
    lateinit var presenter: ConfirmEmailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemUtils.setTransparentForStatusBar(this)
        setContentView(R.layout.activity_confirm_email)

        var rootView = findViewById<View>(android.R.id.content)
        var view = ConfirmEmailView(rootView, this)
        presenter = ConfirmEmailPresenter(view, navigationController!!)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(
            R.anim.right_to_left_in,
            R.anim.right_to_left_out
        )
    }

    override fun onResume() {
        super.onResume()
        presenter?.let {
            it.resume()
        }
    }

    override fun onPause() {
        presenter?.let {
            it.pause()
        }
        super.onPause()
    }
}
