package com.meetropolys.meetropolys.ui.screen.authorization

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.services.Constants
import com.meetropolys.meetropolys.services.navigation.Screen
import com.meetropolys.meetropolys.services.navigation.ScreenType
import com.meetropolys.meetropolys.tools.SystemUtils
import com.meetropolys.meetropolys.ui.base.BaseActivity
import com.orhanobut.hawk.Hawk

class BaseAuthorizationActivity : BaseActivity() {
    lateinit var presenter: BaseAuthorizationPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemUtils.setTransparentForStatusBar(this)
        setContentView(R.layout.activity_base_authorization)
        handleCurrentScreen()
        var rootView = findViewById<View>(android.R.id.content)
        var view = BaseAuthorizationView(rootView,baseContext)
        presenter = BaseAuthorizationPresenter(view, navigationController)
    }

    private fun handleCurrentScreen() {
        if (Hawk.contains(Constants.FRAGMENT_KEY)) {
            val screen = Hawk.get<Any>(Constants.FRAGMENT_KEY)
            when (screen) {
            }
        } else {
            navigationController.setNavigationContainer(R.id.content_frame)
            navigationController.navigateTo(Screen.SIGN_IN_FRAGMENT, ScreenType.FRAGMENT)
        }
    }

    override fun onResume() {
        super.onResume()
        presenter?.resume()
    }

    override fun onPause() {
        presenter?.pause()
        super.onPause()
    }
}
