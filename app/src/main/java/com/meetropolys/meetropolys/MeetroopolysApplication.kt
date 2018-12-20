package com.meetropolys.meetropolys

import android.support.multidex.MultiDexApplication
import com.meetropolys.meetropolys.services.Constants
import com.orhanobut.hawk.Hawk


class MeetroopolysApplication : MultiDexApplication() {

    companion object {
        lateinit var instance: MeetroopolysApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Hawk.init(this).build()
        Hawk.delete(Constants.FRAGMENT_KEY)

    }
}