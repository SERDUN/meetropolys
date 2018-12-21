package com.meetropolys.meetropolys.tools

object Tools {
    fun isValidEmail(target: String?): Boolean {
        return if (target == null) {
            false
        } else {
            android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

}