package com.meetropolys.meetropolys.services.message

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.meetropolys.meetropolys.MeetroopolysApplication
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.services.Constants

class SystemMessageManager : SystemMessage {
    private var container: ViewGroup? = null
    private var text: TextView? = null

    override fun setViewForMessage(container: ViewGroup, text: TextView) {
        this.container = container
        this.text = text
    }


    override fun showMessage(title: String) {
        if (container == null || text == null) return
        container!!.visibility = View.VISIBLE
        text!!.text = title

    }

    override fun showMessage(title: String, time: Long) {
        if (container == null || text == null) return

        container!!.visibility = View.VISIBLE
        text!!.text = title


        Handler(Looper.getMainLooper()).postDelayed({
            if (container != null) {
                try {
                    container!!.visibility = View.GONE
                    text!!.text = title
                } catch (e: Exception) {
                    Log.d(
                        Constants.LOG_ERROR,
                        MeetroopolysApplication.instance.getString(R.string.error_actitvity_was_destroyed)
                    )
                }

            }


        }, time)


    }

    override fun hideMessage() {
        if (container == null || text == null) return
        container!!.visibility = View.GONE
        text!!.text = ""


    }


}
