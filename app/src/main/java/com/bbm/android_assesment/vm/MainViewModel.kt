package com.bbm.android_assesment.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _availableBalance = MutableLiveData<Long>(50000L)
    val availableBalance = _availableBalance.hide()

    private val _errorText  = MutableLiveData<String?>(null)
    val errorText = _errorText.hide()

    val edtAmount = MutableLiveData("")

}

fun <T> MutableLiveData<T>.hide(): LiveData<T> = this