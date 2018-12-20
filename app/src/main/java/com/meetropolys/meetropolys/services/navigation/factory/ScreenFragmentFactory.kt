package com.meetropolys.meetropolys.services.navigation.factory

import android.content.Context
import android.support.v4.app.Fragment
import com.meetropolys.meetropolys.MeetroopolysApplication
import com.meetropolys.meetropolys.services.navigation.Screen
import com.meetropolys.meetropolys.ui.base.BaseFragment
import com.meetropolys.meetropolys.ui.screen.authorization.confirm_email.ConfirmEmailFragment
import com.meetropolys.meetropolys.ui.screen.authorization.sign_in.SignInFragment
import com.meetropolys.meetropolys.ui.screen.authorization.sign_up.SignUpFragment

class ScreenFragmentFactory {
    protected var context: Context? = null

    fun getFragmentByType(type: Screen): Fragment {
        val clazz = getFragmentClassByType(type)
        return Fragment.instantiate(MeetroopolysApplication.instance.applicationContext, clazz.name)
    }


    fun getFragmentClassByType(type: Screen): Class<out Fragment> {
        when (type) {
            Screen.SIGN_IN_FRAGMENT -> return SignInFragment::class.java
            Screen.SIGN_UP_FRAGMENT -> return SignUpFragment::class.java
            Screen.CONFIRM_EMAIL_FRAGMENT -> return ConfirmEmailFragment::class.java
        }
        return BaseFragment::class.java

    }

}
