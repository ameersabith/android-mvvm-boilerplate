package com.sabith_ak.mvvmbase.injection

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ApplicationModule {
    @Provides
    @Singleton
    open fun provideApplication(application: Application): Context = application
}