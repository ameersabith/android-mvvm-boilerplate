package com.sabith_ak.mvvmbase.data.remote

import com.sabith_ak.mvvmbase.data.model.OauthRequest
import com.sabith_ak.mvvmbase.data.model.OauthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    /**
     * Authentication
     **/
    @POST("oauth/token")
    fun authenticateUser(
        @Body params: OauthRequest
    ): Call<OauthResponse>

}