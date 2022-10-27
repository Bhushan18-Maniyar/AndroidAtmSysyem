package com.bbm.android_assesment.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _availableBalance = MutableLiveData<Long>(50000L)
    val availableBalance = _availableBalance.hide()

    private val _errorText = MutableLiveData<String?>(null)
    val errorText = _errorText.hide()

    val edtAmount = MutableLiveData("")

    private val _countOfNotes = MutableLiveData("")
    val countOfNotes = _countOfNotes.hide()

    private fun validateInput(): Boolean {
        _countOfNotes.postValue("")
        if (edtAmount.value.isNullOrEmpty()) {
            _errorText.postValue("Please Enter valid amount")
            return false
        }

        if (edtAmount.value?.toLongOrNull() == null) {
            _errorText.postValue("Please Enter valid amount")
            return false
        }

        if (edtAmount.value!!.toLong() % 10 != 0L) {
            _errorText.postValue("Please Enter amount which is multiple of 10")
            return false
        }

        if (edtAmount.value!!.toLong() > _availableBalance.value!!) {
            _errorText.postValue("Insufficient  Balance!")
            return false
        }

        _errorText.postValue(null)
        return true
    }

    fun withDrawAmount() {
        if (validateInput()) {
            var amountToBeWithdraw = edtAmount.value!!.toLong()

            _availableBalance.value = _availableBalance.value!! - amountToBeWithdraw

            val note_2000 = amountToBeWithdraw / 2000
            amountToBeWithdraw -= note_2000 * 2000

            val note_500 = amountToBeWithdraw / 500
            amountToBeWithdraw -= note_500 * 500

            val note_200 = amountToBeWithdraw / 200
            amountToBeWithdraw -= note_200 * 200

            val note_100 = amountToBeWithdraw / 100
            amountToBeWithdraw -= note_100 * 100

            val note_50 = amountToBeWithdraw / 50
            amountToBeWithdraw -= note_50 * 50

            val note_20 = amountToBeWithdraw / 20

            _countOfNotes.postValue(
                " 2000: $note_2000 notes" +
                        "\n 500: $note_500 notes" +
                        "\n 200: $note_200 notes" +
                        "\n 100: $note_100 notes" +
                        "\n 50: $note_50 notes" +
                        "\n 20: $note_20 notes"
            )
        }
    }

}

fun <T> MutableLiveData<T>.hide(): LiveData<T> = this