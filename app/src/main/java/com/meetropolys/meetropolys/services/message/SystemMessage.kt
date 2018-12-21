package com.meetropolys.meetropolys.services.message

import android.view.TextureView
import android.view.ViewGroup
import android.widget.TextView

interface SystemMessage {
    fun showMessage(title: String)
    fun showMessage(title: String, time: Long)
    fun hideMessage()
    fun setViewForMessage(container: ViewGroup,text: TextView)


}
