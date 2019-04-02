package com.mobilebox.blog.data

import com.mobilebox.blog.BlogDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.with

const val DATABASE_FILENAME: String = "databaseFileName"

val dbModule = Kodein.Module("DbModule") {
    constant(tag = DATABASE_FILENAME) with "blog.db"

    bind<BlogDatabase>() with provider {
        createQueryWrapper(AndroidSqliteDriver(Schema, instance(), instance(tag = DATABASE_FILENAME)))
    }

    bind<LogEntryQueries>() with provider {
        instance<BlogDatabase>().logEntryQueries
    }

    bind<ContractorQueries>() with provider {
        instance<BlogDatabase>().contractorQueries
    }

    bind<EntryJobQueries>() with provider {
        instance<BlogDatabase>().entryJobQueries
    }
}