package com.mobilebox.blog

import android.app.Application
import android.content.Context
import com.mobilebox.blog.data.dbModule
import com.mobilebox.blog.repository.LogEntryRepositiory
import com.mobilebox.blog.repository.impl.LogEntryRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import timber.log.Timber

class BlogApplication : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        //import(androidXModule(this@BlogApplication))
        bind<Context>() with provider { applicationContext }

        import(dbModule)

        bind<LogEntryRepositiory>() with singleton { LogEntryRepositoryImpl(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }
}