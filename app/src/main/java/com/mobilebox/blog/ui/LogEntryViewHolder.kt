package com.mobilebox.blog.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilebox.blog.R
import com.mobilebox.blog.data.LogEntry
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.logentry.*
import java.text.SimpleDateFormat

class LogEntryViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.logentry, parent, false)),
    LayoutContainer {

    override val containerView = itemView

    /**
     * Items might be null if they are not paged in yet. PagedListAdapter will re-bind the
     * ViewHolder when Item is loaded.
     */
    fun bindTo(logEntry: LogEntry?) {
        logEntry?.let {
            note.text = logEntry.note
            start.text = timeFormat.format(logEntry.start)
            finish.text = timeFormat.format(logEntry.finish)
        }
    }

    companion object {
        val timeFormat = SimpleDateFormat("HH:mm")
    }
}