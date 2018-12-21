package com.meetropolys.meetropolys

import android.support.multidex.MultiDexApplication
import com.meetropolys.meetropolys.services.Constants
import com.orhanobut.hawk.Hawk


class MeetropolysApplication : MultiDexApplication() {

    companion object {
        lateinit var instance: MeetropolysApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Hawk.init(this).build()
        Hawk.delete(Constants.FRAGMENT_KEY)

    }
}