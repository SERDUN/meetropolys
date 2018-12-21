package com.meetropolys.meetropolys.repository.local

interface LocaleRepository{

    public fun saveUserLoginPassword(pass:String,email:String)
    public fun saveUserInformation(name:String)


    public fun getUserPassword():String
    public fun getUserEmail():String
    public fun getUserInformation():String




}
