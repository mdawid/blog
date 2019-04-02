package com.mobilebox.blog.model

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val kodeinViewModel = Kodein.Module(name = "viewModel") {
    bind() from provider { ViewModelFactory(instance()) }
}