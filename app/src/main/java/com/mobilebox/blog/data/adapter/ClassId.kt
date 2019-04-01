package com.mobilebox.blog.data.adapter

import com.squareup.sqldelight.ColumnAdapter


inline class LogEntryId(val value: Long)
inline class ContractorId(val value: Long)

class LogEntryIdAdapter : ColumnAdapter<LogEntryId, Long> {
    override fun encode(value: LogEntryId) = value.value
    override fun decode(databaseValue: Long) = LogEntryId(databaseValue)
}

class ContractorIdIdAdapter : ColumnAdapter<ContractorId, Long> {
    override fun encode(value: ContractorId) = value.value
    override fun decode(databaseValue: Long) = ContractorId(databaseValue)
}