package com.mobilebox.blog.ui

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.mobilebox.blog.data.LogEntry

class LogEntryAdapter : PagedListAdapter<LogEntry, LogEntryViewHolder>(diffCallback) {
    override fun onBindViewHolder(holder: LogEntryViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LogEntryViewHolder(parent)

    companion object {
        /**
         * This diff callback informs the PagedListAdapter how to compute list differences when new
         * PagedLists arrive.
         * <p>
         * When you add an item with the 'Add' button, the PagedListAdapter uses diffCallback to
         * detect there's only a single item difference from before, so it only needs to animate and
         * rebind a single view.
         *
         * @see android.support.v7.util.DiffUtil
         */
        private val diffCallback = object : DiffUtil.ItemCallback<LogEntry>() {
            override fun areItemsTheSame(oldItem: LogEntry, newItem: LogEntry): Boolean =
                    oldItem.id == newItem.id

            /**
             * Note that in kotlin, == checking on data classes compares all contents, but in Java,
             * typically you'll implement Object#equals, and use it to compare object contents.
             */
            override fun areContentsTheSame(oldItem: LogEntry, newItem: LogEntry): Boolean =
                    oldItem == newItem
        }
    }
} 