package com.sabith_ak.mvvmbase.injection

import com.sabith_ak.mvvmbase.ui.login.LoginActivity
import com.sabith_ak.mvvmbase.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
    @ContributesAndroidInjector
    abstract fun bindLoginActivity(): LoginActivity
}