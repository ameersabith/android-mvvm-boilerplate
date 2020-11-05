package com.sabith_ak.mvvmbase.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sabith_ak.mvvmbase.databinding.ActivityMainBinding
import com.sabith_ak.mvvmbase.BR
import com.sabith_ak.mvvmbase.R
import com.sabith_ak.mvvmbase.ViewModelProviderFactory
import com.sabith_ak.mvvmbase.ui.base.BaseActivity
import com.sabith_ak.mvvmbase.util.toast
import javax.inject.Inject

class MainActivity : BaseActivity<
        ActivityMainBinding,
        MainActivityViewModel
        >(),
    MainActivityNavigator {

    @Inject
    lateinit var factory: ViewModelProviderFactory
    lateinit var mainViewModel: MainActivityViewModel
    lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = getViewDataBinding()
        mainViewModel.navigator = this

    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainActivityViewModel {
        mainViewModel = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)
        return mainViewModel
    }
}