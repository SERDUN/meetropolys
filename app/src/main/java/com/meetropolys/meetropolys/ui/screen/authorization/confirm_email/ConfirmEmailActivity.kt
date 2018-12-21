package com.meetropolys.meetropolys.ui.screen.authorization.confirm_email

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.tools.SystemUtils
import com.meetropolys.meetropolys.ui.base.BaseActivity

class ConfirmEmailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemUtils.setTransparentForStatusBar(this)
        setContentView(R.layout.activity_confirm_email)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(
            R.anim.right_to_left_in,
            R.anim.right_to_left_out
        )
    }
}
