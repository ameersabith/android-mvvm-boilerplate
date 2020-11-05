package com.sabith_ak.mvvmbase.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
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
        toast("Click Worked!")
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
    }
}