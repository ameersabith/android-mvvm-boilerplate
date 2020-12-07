package com.sabith_ak.mvvmbase.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import com.sabith_ak.mvvmbase.BR
import com.sabith_ak.mvvmbase.R
import com.sabith_ak.mvvmbase.ViewModelProviderFactory
import com.sabith_ak.mvvmbase.databinding.ActivityLoginBinding
import com.sabith_ak.mvvmbase.ui.base.BaseActivity
import com.sabith_ak.mvvmbase.ui.main.MainActivity
import com.sabith_ak.mvvmbase.util.toast
import javax.inject.Inject

class LoginActivity : BaseActivity<
        ActivityLoginBinding,
        LoginActivityViewModel
        >(),
    LoginActivityNavigator {

    @Inject
    lateinit var factory: ViewModelProviderFactory
    lateinit var loginViewModel: LoginActivityViewModel
    lateinit var viewBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = getViewDataBinding()
        loginViewModel.navigator = this

       /* loginViewModel.getLoginResult().observe(this, { result ->
            loginViewModel.navigateToMainActivity()
        })*/

    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun getViewModel(): LoginActivityViewModel {
        loginViewModel = ViewModelProvider(this, factory).get(LoginActivityViewModel::class.java)
        return loginViewModel
    }

    override fun onNavigateToMainActivityClicked() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
    }

    override fun onValidationComplete(isSuccess: Boolean, message: String) {
        if (isSuccess) {
            loginViewModel.navigateToMainActivity()
        } else {
            toast(message)
        }
    }

    object DataBindingAdapter {
        @BindingAdapter("app:errorText")
        @JvmStatic
        fun setErrorMessage(view: TextInputLayout, errorMessage: String) {
            view.error = errorMessage
        }
    }
}