package com.sabith_ak.mvvmbase.data.remote

import android.content.Context
import com.google.gson.GsonBuilder
import com.sabith_ak.mvvmbase.data.local.SharedPreferenceHelper
import com.sabith_ak.mvvmbase.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

open class NetworkManager {
    companion object {

        private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BODY)

        private fun getRetrofitInstance(context: Context): Retrofit {
            return Retrofit
                .Builder()
                .baseUrl(Constants.BASE_URL_SERVER)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(logging)
                        .addInterceptor{ chain ->
                            val newRequest = chain.request().newBuilder()
                                .addHeader("Authorization", "Bearer ${SharedPreferenceHelper(context).accessToken}")
                                .addHeader("Content-Type", "application/json")
                                .build()
                            chain.proceed(newRequest)
                        }.build())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                .build()
        }

        fun getApiService(context: Context): ApiService? {
            var retroInstance: ApiService? = null
            try {
                retroInstance = getRetrofitInstance(context).create(ApiService::class.java)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return retroInstance
        }
    }
}