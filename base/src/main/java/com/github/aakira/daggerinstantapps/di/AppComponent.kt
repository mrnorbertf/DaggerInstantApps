package com.github.aakira.daggerinstantapps.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.github.aakira.daggerinstantapps.App
import com.github.aakira.daggerinstantapps.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    AppModule::class,
    PreferencesModule::class,
    AndroidSupportInjectionModule::class
])
interface AppComponent : AndroidInjector<App>, DaggerComponent, AppComponentProviders {

    override fun inject(instance: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }


    fun context(): Context
    fun pref(): SharedPreferences
}

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context =
            application.applicationContext

}


@Module
class PreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences("user", Context.MODE_PRIVATE)
}
