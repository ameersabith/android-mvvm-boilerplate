package com.sabith_ak.mvvmbase.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferenceHelper(context: Context) {

    companion object {
        private const val PREFERENCE_FILENAME = "mvvm_base_preference"

        private const val KEY_SERVER_BASE_URL = "server_url"

        private const val KEY_ACCESS_TOKEN = "access_token"
        private const val KEY_REFRESH_TOKEN = "refresh_token"
        private const val KEY_TOKEN_TYPE = "token_type"
        private const val KEY_EXPIRES_IN = "expires_in"

        private const val KEY_IS_AUTHENTICATED = "login_status"

        private const val KEY_USER_NAME = "user_name"
        private const val KEY_USER_EMAIL = "user_email"
        private const val KEY_PASSWORD = "user_word"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_USER_IMAGE = "user_image"

    }

    private val sharedPreference: SharedPreferences =
            context.getSharedPreferences(PREFERENCE_FILENAME, Context.MODE_PRIVATE)

    var serverUrl: String
        get() = sharedPreference.getString(KEY_SERVER_BASE_URL, "") ?: ""
        set(value) = sharedPreference.edit{ putString(KEY_SERVER_BASE_URL, value)}

    var userName: String
        get() = sharedPreference.getString(KEY_USER_NAME, "") ?: ""
        set(value) = sharedPreference.edit{ putString(KEY_USER_NAME, value)}

    var userEmail: String
        get() = sharedPreference.getString(KEY_USER_EMAIL, "") ?: ""
        set(value) = sharedPreference.edit{ putString(KEY_USER_EMAIL, value)}

    var password: String
        get() = sharedPreference.getString(KEY_PASSWORD, "") ?: ""
        set(value) = sharedPreference.edit{ putString(KEY_PASSWORD, value)}

    var accessToken: String
        get() = sharedPreference.getString(KEY_ACCESS_TOKEN, "") ?: ""
        set(value) = sharedPreference.edit{ putString(KEY_ACCESS_TOKEN, value)}

    var refreshToken: String
        get() = sharedPreference.getString(KEY_REFRESH_TOKEN, "") ?: ""
        set(value) = sharedPreference.edit { putString(KEY_REFRESH_TOKEN, value) }

    var tokenType: String
        get() = sharedPreference.getString(KEY_TOKEN_TYPE, "Bearer") ?: ""
        set(value) = sharedPreference.edit{ putString(KEY_TOKEN_TYPE, value)}

    var expiresIn: Long
        get() = sharedPreference.getLong(KEY_EXPIRES_IN, 0)
        set(value) = sharedPreference.edit { putLong(KEY_EXPIRES_IN, value) }

    var userId: Int
        get() = sharedPreference.getInt(KEY_USER_ID, 0)
        set(value) = sharedPreference.edit { putInt(KEY_USER_ID, value) }

    var userImage: String
        get() = sharedPreference.getString(KEY_USER_IMAGE, "") ?: ""
        set(value) = sharedPreference.edit { putString(KEY_USER_IMAGE, value) }

    var loginStatus: Boolean
        get() = sharedPreference.getBoolean(KEY_IS_AUTHENTICATED, false)
        set(value) = sharedPreference.edit { putBoolean(KEY_IS_AUTHENTICATED, value) }
}

/*
//Example Usage
val prefs = Prefs(context)

// get stored value
val myString = prefs.myString

// store value
prefs.myString = "My String Value"

// get stored array
val myStringArray = prefs.myStringArray

// store array
prefs.myStringArray = arrayOf("String 1","String 2","String 3")*/
