package com.kindred

import android.app.Application
import com.facebook.stetho.Stetho
import com.kindred.di.component.AppComponents
import com.kindred.di.component.DaggerAppComponents
import com.kindred.di.modules.AppModule
import com.kindred.utils.InternetUtil
import timber.log.Timber

open class MainApplication : Application() {

    companion object {
        lateinit var appComponents: AppComponents
    }

    override fun onCreate() {
        super.onCreate()
        appComponents = initDagger(this)
        initStetho()
        initTimber()
        InternetUtil.init(this)
    }

    private fun initDagger(app: MainApplication): AppComponents =
        DaggerAppComponents.builder()
            .appModule(AppModule(app))
            .build()

    private fun initStetho() {
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}