package com.mobilebox.blog.repository

import androidx.paging.DataSource
import com.mobilebox.blog.data.LogEntry

interface LogEntryRepositiory {
    fun findAll(): DataSource.Factory<Int, LogEntry>
}