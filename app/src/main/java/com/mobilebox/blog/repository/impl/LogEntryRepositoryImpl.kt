package com.mobilebox.blog.repository.impl

import androidx.paging.DataSource
import com.mobilebox.blog.data.LogEntry
import com.mobilebox.blog.data.LogEntryQueries
import com.mobilebox.blog.repository.LogEntryRepositiory
import com.squareup.sqldelight.android.paging.QueryDataSourceFactory

class LogEntryRepositoryImpl( val logEntryQueries: LogEntryQueries ) : LogEntryRepositiory {
    override fun findAll(): DataSource.Factory<Int, LogEntry> {
        return QueryDataSourceFactory(
            queryProvider = logEntryQueries::logEntries,
            countQuery = logEntryQueries.countLogEntries()
        )
    }
}