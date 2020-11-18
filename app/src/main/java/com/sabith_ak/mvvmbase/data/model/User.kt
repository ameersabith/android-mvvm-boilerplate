package com.sabith_ak.mvvmbase.data.model

import androidx.annotation.Keep
@Keep
data class UserDataMain(
    val status: Boolean = false,
    val error: String = "",
    val data: User? = null
)

@Keep
data class User(
    val id: Int = 0,
    val name: String = ""
)