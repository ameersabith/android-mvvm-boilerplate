package com.sabith_ak.mvvmbase.ui.login

interface LoginActivityNavigator {
    fun onNavigateToMainActivityClicked()

    fun onValidationComplete(isSuccess: Boolean, message: String)
}