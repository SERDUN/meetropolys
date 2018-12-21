package com.meetropolys.meetropolys.ui.base.mvp

import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.meetropolys.meetropolys.MeetroopolysApplication
import com.meetropolys.meetropolys.R
import com.meetropolys.meetropolys.services.Constants
import com.meetropolys.meetropolys.ui.base.BaseActivity
import io.reactivex.Observable
import java.util.*

open class SocialView(var baseActivity: BaseActivity) : SocialContract {
    var premmisions =
        Arrays.asList(MeetroopolysApplication.instance.resources.getStringArray(R.array.my_facebook_permission))[0]

    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(baseActivity.getString(R.string.client_id))
        .requestServerAuthCode(baseActivity.getString(R.string.client_id))
        .requestEmail()
        .build()


    public override fun googleAuth() {
        var mGoogleSignInClient = GoogleSignIn.getClient(baseActivity, gso);

        val signInIntent = mGoogleSignInClient.signInIntent
        baseActivity.startActivityForResult(signInIntent, Constants.GOOGLE_AUTH_KEY)
    }

    public override fun facebookAuth() {
        LoginManager.getInstance().logInWithReadPermissions(baseActivity, premmisions.toList())
    }

    public override fun onResultAuth(): Observable<BaseActivity.OnActivityResult> {
        return baseActivity.onActivityResultListener
    }


}
