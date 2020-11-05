package com.sabith_ak.mvvmbase.injection

import com.sabith_ak.mvvmbase.MvvmBaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@SuppressWarnings("unchecked")
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityBuilder::class
    ]
)
@Singleton
interface ApplicationComponent: AndroidInjector<MvvmBaseApplication> {
    override fun inject(application: MvvmBaseApplication)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: MvvmBaseApplication): Builder
        fun build(): ApplicationComponent
    }
}