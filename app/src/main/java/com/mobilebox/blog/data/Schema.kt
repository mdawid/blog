package com.mobilebox.blog.data

import com.mobilebox.blog.BlogDatabase
import com.mobilebox.blog.data.adapter.ContractorIdIdAdapter
import com.mobilebox.blog.data.adapter.DateAdapter
import com.mobilebox.blog.data.adapter.ListOfStringsAdapter
import com.mobilebox.blog.data.adapter.LogEntryIdAdapter
import com.squareup.sqldelight.EnumColumnAdapter
import com.squareup.sqldelight.db.SqlDriver

fun createQueryWrapper(driver: SqlDriver): BlogDatabase {
    return BlogDatabase(
        driver = driver,
        logEntryAdapter = LogEntry.Adapter(
            idAdapter = LogEntryIdAdapter(),
            startAdapter = DateAdapter(),
            finishAdapter = DateAdapter(),
            typeAdapter = EnumColumnAdapter()
        ),
        contractorAdapter = Contractor.Adapter(
            idAdapter = ContractorIdIdAdapter(),
            tagsAdapter = ListOfStringsAdapter()
        ),
        entryJobAdapter = EntryJob.Adapter(
            entryIdAdapter = LogEntryIdAdapter(),
            contractorIdAdapter = ContractorIdIdAdapter()
        )
    )
}

object Schema : SqlDriver.Schema by BlogDatabase.Schema {
    override fun create(driver: SqlDriver) {
        BlogDatabase.Schema.create(driver)

        createQueryWrapper(driver).apply {
            contractorQueries.insertContractor("Florentyna", listOf("florentyna", "flo", "flora"))
            contractorQueries.insertContractor("Szeszycki", listOf("szeszycki", "szeszyc", "szesz"))
            contractorQueries.insertContractor("Sobieski", listOf("sobieski", "sopieski"))
            contractorQueries.insertContractor("Indigo", listOf("indigo", "indygo", "indi"))
        }
    }
}
