package com.bbm.android_assesment.di

import com.bbm.android_assesment.vm.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


private val viewModels = module {
    viewModel { MainViewModel() }
}

val koinModules = listOf(viewModels)