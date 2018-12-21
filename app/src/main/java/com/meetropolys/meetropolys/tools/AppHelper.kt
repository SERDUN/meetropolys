package com.meetropolys.meetropolys.tools

import android.annotation.SuppressLint
import android.content.Context
import com.meetropolys.meetropolys.repository.local.LocalRepositoryImpl
import com.meetropolys.meetropolys.repository.local.LocaleRepository

@SuppressLint("StaticFieldLeak")
object AppHelper {
    lateinit var context: Context
    //    var userCredentials = UserCredentials()
    val api: LocaleRepository by lazy { LocalRepositoryImpl() }
}