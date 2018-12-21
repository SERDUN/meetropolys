package com.meetropolys.meetropolys.ui.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.inputmethod.InputMethodManager
import com.meetropolys.meetropolys.services.navigation.NavigationController
import com.meetropolys.meetropolys.services.navigation.ScreenNavigationManager

open class BaseActivity : AppCompatActivity() {
    protected val TAG = javaClass.simpleName

    class OnActivityResult(var requestCode: Int, var resultCode: Int, var data: Intent?)

    public var onActivityResultListener = io.reactivex.subjects.PublishSubject.create<OnActivityResult>()

  lateinit  var navigationController: NavigationController
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, " onCreate()" + if (savedInstanceState != null) " recreating" else "")
        navigationController = ScreenNavigationManager(this)
        super.onCreate(savedInstanceState)

    }

    override fun onDestroy() {
        onActivityResultListener.onComplete()
        super.onDestroy()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        onActivityResultListener.onNext(OnActivityResult(requestCode, resultCode, data))
        super.onActivityResult(requestCode, resultCode, data)
    }


    fun hideKeyboard() {
        try {
            Handler(Looper.getMainLooper()).postDelayed({
                val windowToken = window.decorView.rootView.windowToken
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(windowToken, 0)
            }, 100)

        } catch (e: Exception) {
            Log.e(TAG, e.localizedMessage)
        }

    }

    fun freeMemory() {
        System.runFinalization()
        Runtime.getRuntime().gc()
        System.gc()
    }
}
