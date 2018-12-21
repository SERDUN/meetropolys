package com.meetropolys.meetropolys.services.navigation.factory

import android.app.Activity
import android.content.Intent
import com.meetropolys.meetropolys.MeetroopolysApplication
import com.meetropolys.meetropolys.services.navigation.Screen
import com.meetropolys.meetropolys.ui.screen.authorization.BaseAuthorizationActivity
import com.meetropolys.meetropolys.ui.screen.authorization.confirm_email.ConfirmEmailActivity
import com.meetropolys.meetropolys.ui.screen.authorization.confirm_email.ConfirmEmailFragment

class ScreenActivityFactory {
    fun getActivityByType(type: Screen): Intent {
        val clazz = getActivityClassByType(type)
        return Intent(MeetroopolysApplication.instance.applicationContext, clazz)
    }

    fun getActivityClassByType(type: Screen): Class<out Activity> {
        when (type) {
            Screen.AUTHORIZATION_ACTIVITY -> return BaseAuthorizationActivity::class.java
            Screen.CONFIRM_EMAIL_ACTIVITY -> return ConfirmEmailActivity::class.java

        }
        return BaseAuthorizationActivity::class.java
    }
}
