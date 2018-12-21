package com.meetropolys.meetropolys.ui.profile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.ui.base.BaseActivity

class ProfileActivity : BaseActivity() {
    lateinit var presenter: ProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var rootView = findViewById<View>(android.R.id.content)
        var view = ProfileView(rootView, baseContext)
        presenter = ProfilePresenter(view, navigationController!!)
    }
}
