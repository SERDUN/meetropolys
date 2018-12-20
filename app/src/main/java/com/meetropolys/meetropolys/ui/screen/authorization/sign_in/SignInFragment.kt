package com.meetropolys.meetropolys.ui.screen.authorization.sign_in


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.ui.base.BaseActivity
import com.meetropolys.meetropolys.ui.screen.authorization.BaseAuthorizationPresenter
import com.meetropolys.meetropolys.ui.screen.authorization.BaseAuthorizationView

class SignInFragment : Fragment() {
    lateinit var presenter: SignInPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView= inflater.inflate(R.layout.fragment_sign_in, container, false)


        var view = SignInView(rootView,context!!)
        presenter = SignInPresenter(view, (activity as BaseActivity).navigationController)

   return rootView;
    }


}
