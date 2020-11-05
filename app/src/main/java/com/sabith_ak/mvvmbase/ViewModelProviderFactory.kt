package com.sabith_ak.mvvmbase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sabith_ak.mvvmbase.ui.login.LoginActivityViewModel
import com.sabith_ak.mvvmbase.ui.main.MainActivityViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Suppress("UNCHECKED_CAST")
@Singleton
class ViewModelProviderFactory @Inject constructor(): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(LoginActivityViewModel::class.java) -> LoginActivityViewModel() as T
            modelClass.isAssignableFrom(MainActivityViewModel::class.java) -> MainActivityViewModel() as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}