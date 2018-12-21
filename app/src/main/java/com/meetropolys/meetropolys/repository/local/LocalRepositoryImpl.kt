package com.meetropolys.meetropolys.repository.local

import com.meetropolys.meetropolys.services.Constants
import com.orhanobut.hawk.Hawk

class LocalRepositoryImpl : LocaleRepository {
    override fun saveUserLoginPassword(pass: String, email: String) {
        Hawk.put(Constants.USER_EMAIL, email)
        Hawk.put(Constants.USER_PASSWORD, pass)
    }

    override fun saveUserInformation(name: String) {
        Hawk.put(Constants.USER_INFORMATION, name)

    }
}
