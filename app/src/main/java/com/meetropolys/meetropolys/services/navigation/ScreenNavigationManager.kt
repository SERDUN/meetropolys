package com.meetropolys.meetropolys.services.navigation

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.util.Log
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.services.navigation.factory.ScreenActivityFactory
import com.meetropolys.meetropolys.services.navigation.factory.ScreenFragmentFactory
import com.meetropolys.meetropolys.ui.base.BaseActivity

class ScreenNavigationManager(private val activity: BaseActivity) : NavigationController {
    private var currentNavigationContainer: Int = 0
    private var activeScreen = Screen.NONE
    private val previousScreen = Screen.NONE
    private val fragmentFactory: ScreenFragmentFactory
    private val activityFactory: ScreenActivityFactory

    init {
        fragmentFactory = ScreenFragmentFactory()
        activityFactory = ScreenActivityFactory()
    }

    override fun navigateTo(screen: Screen, type: ScreenType) {
        navigateTo(screen, type, null!!)

    }

    override fun navigateTo(screen: Screen, type: ScreenType, bundle: Bundle) {
        when (type) {
            ScreenType.ACTIVITY -> navigateToActivity(screen, bundle)
            ScreenType.FRAGMENT -> navigateToFragment(screen, bundle)
        }
    }

    private fun navigateToFragment(screen: Screen, bundle: Bundle) {
        when (screen) {
            Screen.SIGN_IN_FRAGMENT -> navigateToSignInFragment(bundle)
            Screen.SIGN_UP_FRAGMENT -> navigateToSignUpFragment(bundle)
        }

    }

    private fun navigateToSignInFragment(bundle: Bundle) {
        activeScreen = Screen.SIGN_IN_FRAGMENT
        switchFragmentScreen(Screen.SIGN_IN_FRAGMENT, bundle, true, false, currentNavigationContainer)
    }

    private fun navigateToSignUpFragment(bundle: Bundle) {
        activeScreen = Screen.SIGN_UP_FRAGMENT
        switchFragmentScreen(Screen.SIGN_UP_FRAGMENT, bundle, true, false, currentNavigationContainer)
    }

    private fun navigateToActivity(screen: Screen, bundle: Bundle) {
        when (screen) {
            Screen.AUTHORIZATION_ACTIVITY -> navigateToRegisterActivity(bundle)
        }

    }

    private fun navigateToRegisterActivity(bundle: Bundle) {
        switchActivityScreen(Screen.AUTHORIZATION_ACTIVITY, bundle, ScreenAnimType.FADE_TYPE)

        activity.hideKeyboard()
        activity.finish()
        activity.freeMemory()
    }

    private fun switchActivityScreen(type: Screen, bundle: Bundle?, animate: ScreenAnimType) {
        val intent = activityFactory.getActivityByType(type)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        if (bundle != null && !bundle.isEmpty) {
            intent.putExtras(bundle)
        }

        activity.startActivity(intent)
        when (animate) {
            ScreenAnimType.FADE_TYPE -> activity.overridePendingTransition(
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            ScreenAnimType.RIGHT_TO_LEFT_TYPE -> activity.overridePendingTransition(
                R.anim.right_to_left_in,
                R.anim.right_to_left_out
            )
            ScreenAnimType.LEFT_TO_RIGHT_TYPE -> activity.overridePendingTransition(
                R.anim.left_to_right_in,
                R.anim.left_to_right_out
            )
            ScreenAnimType.UP_TO_DOWN_TYPE -> activity.overridePendingTransition(
                R.anim.up_to_down_in,
                R.anim.up_to_down_out
            )
        }
    }

    private fun isSameFragmentAlreadyPlaced(type: Screen): Boolean {
        val existing = activity.supportFragmentManager.findFragmentById(R.id.content_frame)
        if (existing != null) {
            val requested = fragmentFactory.getFragmentClassByType(type)
            if (existing.javaClass == requested) {
                return true
            }
        }
        return false
    }

    private fun switchFragmentScreen(
        type: Screen,
        bundle: Bundle?,
        animate: Boolean,
        addToBackStack: Boolean,
        idContainer: Int
    ) {
        if (isSameFragmentAlreadyPlaced(type))
            return

        val fragmentManager = activity.supportFragmentManager
        val tran = fragmentManager.beginTransaction()
        if (animate) {
            tran.setCustomAnimations(R.anim.popup_in, R.anim.popup_out)
        }

        val fragment = fragmentFactory.getFragmentByType(type)
        if (bundle != null && !bundle.isEmpty) {
            fragment.arguments = bundle
        }
        if (addToBackStack) {
            if (animate) {
                tran.setCustomAnimations(
                    R.anim.right_to_left_in,
                    R.anim.right_to_left_out,
                    R.anim.left_to_right_in,
                    R.anim.left_to_right_out
                )
            }
            tran.replace(idContainer, fragment, fragment.javaClass.simpleName)
            tran.addToBackStack(fragment.javaClass.simpleName)
        } else {
            if (animate) {
                tran.setCustomAnimations(R.anim.popup_in, R.anim.popup_out)
            }
            tran.replace(idContainer, fragment)
        }
        try {
            tran.commitAllowingStateLoss()
        } catch (e: Exception) {
            Log.e(TAG, "Activity destroyed")
        }

    }


    override fun onBack() {

    }


    override fun setNavigationContainer(i: Int) {
        this.currentNavigationContainer = i
    }

    companion object {
        private val TAG = ScreenNavigationManager::class.java.simpleName
        private val EXTRA_ACTIVE_SCREEN = "ScreenNavigationManager.activeScreen"
    }
}
