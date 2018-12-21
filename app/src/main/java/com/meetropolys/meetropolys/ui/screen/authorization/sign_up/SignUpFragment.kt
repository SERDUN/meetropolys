package com.meetropolys.meetropolys.ui.screen.authorization.sign_up


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.ui.base.BaseActivity


class SignUpFragment : Fragment() {
    lateinit var presenter: SignUpPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_sign_up, container, false)
        var baseActivity = (activity as BaseActivity)

        var view = SignUpView(rootView, baseActivity, baseActivity.systemMessage)
        presenter = SignUpPresenter(view, (activity as BaseActivity).navigationController)

        return rootView;
    }


    override fun onPause() {
        presenter.pause()
        super.onPause()

    }


    override fun onResume() {
        super.onResume()
        presenter.resume()

    }


}
