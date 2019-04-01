package com.mobilebox.blog.data.adapter

import com.squareup.sqldelight.ColumnAdapter

class ListOfStringsAdapter : ColumnAdapter<List<String>, String> {
    override fun decode(databaseValue: String) = databaseValue.split(",")
    override fun encode(value: List<String>) = value.joinToString(separator = ",")
}