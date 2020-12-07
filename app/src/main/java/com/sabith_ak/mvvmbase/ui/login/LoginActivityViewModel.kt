package com.sabith_ak.mvvmbase.ui.login

import android.content.Context
import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sabith_ak.mvvmbase.ui.base.BaseViewModel
import java.util.*

class LoginActivityViewModel:
    BaseViewModel<LoginActivityNavigator>() {

    val userName: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()


    /**
     * to pass login result to activity
     * */
    private val loginResult = MutableLiveData<String>()

    val formErrors = ObservableArrayList<FormErrors>()

    /**
     * Called from activity on login button clicked
     * */
    fun isFormValid(): Boolean {
        formErrors.clear()
        if (userName.value.isNullOrBlank()) {
            formErrors.add(FormErrors.MISSING_NAME)
        }
        if (password.value.isNullOrBlank()) {
            formErrors.add(FormErrors.INVALID_PASSWORD)
        }
        return formErrors.isEmpty()
    }

    fun navigateToMainActivity() {
        if (isFormValid())
            navigator?.onNavigateToMainActivityClicked()
    }

    enum class FormErrors{
        MISSING_NAME,
        INVALID_EMAIL,
        INVALID_PASSWORD,
        PASSWORDS_NOT_MATCHING,
    }
}