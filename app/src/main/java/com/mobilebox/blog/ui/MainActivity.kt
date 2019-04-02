package com.mobilebox.blog.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import com.google.android.material.snackbar.Snackbar
import com.mobilebox.blog.di.baseActivityModule
import com.mobilebox.blog.model.LogEntryViewModel
import com.mobilebox.blog.model.ViewModelFactory
import com.mobilebox.blog.model.kodeinViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.instance
import timber.log.Timber


class MainActivity : AppCompatActivity(), KodeinAware {
    val baseKodein by kodein()

    override val kodein: Kodein by retainedKodein {
        extend(baseKodein)
        import(baseActivityModule(this@MainActivity), allowOverride = true)
        import(kodeinViewModel)
    }

    private val viewModelFactory: ViewModelFactory by instance()

    private lateinit var viewModel: LogEntryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.mobilebox.blog.R.layout.activity_main)
        setSupportActionBar(toolbar)

        val dividerItemDecoration = DividerItemDecoration(logEntryList.context, VERTICAL)
        logEntryList.addItemDecoration(dividerItemDecoration)
        val adapter = LogEntryAdapter()
        logEntryList.adapter = adapter

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LogEntryViewModel::class.java)
        viewModel.logEntries.observe(this, Observer(adapter::submitList))
        viewModel.error.observe(this, Observer<String> { Timber.e(it) })

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(com.mobilebox.blog.R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            com.mobilebox.blog.R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
