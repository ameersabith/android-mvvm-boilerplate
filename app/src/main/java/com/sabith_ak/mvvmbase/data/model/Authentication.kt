package com.sabith_ak.mvvmbase.data.model

data class OauthRequest(
    var grant_type: String? = "",
    var client_id: Int? = 0,
    var client_secret: String? = "",
    var username: String? = "",
    var password: String? = ""
)

data class OauthResponse(
    var token_type: String? = "",
    var expires_in: String? = "",
    var access_token: String? = "",
    var refresh_token: String? = ""
)