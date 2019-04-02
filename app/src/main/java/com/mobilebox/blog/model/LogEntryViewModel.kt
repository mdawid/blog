package com.mobilebox.blog.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.Config
import androidx.paging.toLiveData
import com.mobilebox.blog.repository.LogEntryRepositiory

class LogEntryViewModel(private val logEntryRepositiory: LogEntryRepositiory) : ViewModel() {

    val error: MutableLiveData<String> = MutableLiveData()

    val logEntries = logEntryRepositiory.findAll().toLiveData(
        Config(
            pageSize = 30,
            enablePlaceholders = true,
            maxSize = 200
        )
    )

    private fun handleError(error: Exception) {
        this.error.value = error.localizedMessage
    }
}