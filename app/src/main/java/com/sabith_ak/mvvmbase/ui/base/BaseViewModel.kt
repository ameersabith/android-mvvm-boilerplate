package com.sabith_ak.mvvmbase.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>: ViewModel() {

    private val isLoading = ObservableBoolean()
    private var mNavigator: WeakReference<N>? = null

    var navigator: N?
        get() = mNavigator!!.get()
        set(navigator){
            this.mNavigator = WeakReference<N>(navigator)!!
        }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

}