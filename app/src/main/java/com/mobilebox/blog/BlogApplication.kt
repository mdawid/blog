package com.mobilebox.blog

import android.app.Application
import com.mobilebox.blog.data.dbModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.support.androidSupportModule
import timber.log.Timber

class BlogApplication : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        import(androidSupportModule(this@BlogApplication))
        import(dbModule)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }
}