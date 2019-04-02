package com.mobilebox.blog.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobilebox.blog.repository.LogEntryRepositiory

class ViewModelFactory(private val logEntryRepositiory : LogEntryRepositiory ) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LogEntryViewModel(logEntryRepositiory) as T
    }
}