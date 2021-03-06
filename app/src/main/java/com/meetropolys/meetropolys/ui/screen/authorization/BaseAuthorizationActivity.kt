package com.meetropolys.meetropolys.ui.screen.authorization

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
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
        setContentView(R.layout.activity_base_authorization)
        handleCurrentScreen()
        var rootView = findViewById<View>(android.R.id.content)
        var view = BaseAuthorizationView(rootView, baseContext)
        systemMessage.setViewForMessage(findViewById(R.id.container_message_ll), findViewById(R.id.message_tv))
        presenter = BaseAuthorizationPresenter(view, navigationController!!)
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
