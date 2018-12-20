package com.meetropolys.meetropolys.services.navigation

import android.os.Bundle
import com.meetropolys.meetropolys.services.navigation.Screen
import com.meetropolys.meetropolys.services.navigation.ScreenType

interface NavigationController {
    fun navigateTo(screen: Screen, type: ScreenType)
    fun navigateTo(screen: Screen, type: ScreenType, bundle: Bundle?)
    fun setNavigationContainer(int: Int)
    fun onBack()

}
