package com.sabith_ak.mvvmbase.ui.login

import com.sabith_ak.mvvmbase.ui.base.BaseViewModel

class LoginActivityViewModel:
    BaseViewModel<LoginActivityNavigator>() {
    fun navigateToMainActivity() {
        navigator?.onNavigateToMainActivityClicked()
    }
}