package com.mobilebox.blog.data.adapter

import com.squareup.sqldelight.ColumnAdapter
import java.util.*

class DateAdapter : ColumnAdapter<Date, Long> {
    override fun decode(databaseValue: Long) = Date(databaseValue)

    override fun encode(value: Date): Long = value.time
}
