package com.sabith_ak.mvvmbase

import android.app.Activity
import android.app.Application
import com.sabith_ak.mvvmbase.injection.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class MvvmBaseApplication: Application()
    ,HasActivityInjector{

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
//    @Inject
//    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
/*
    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }*/


    override fun onCreate() {
        super.onCreate()
        instance = this

        DaggerApplicationComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }

    companion object {
        lateinit var instance: MvvmBaseApplication
    }
}