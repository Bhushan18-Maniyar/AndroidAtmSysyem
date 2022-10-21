package com.bbm.android_assesment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bbm.android_assesment.vm.MainViewModel


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: MainActivityBinding? = null
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(
            layoutInflater
        ).apply {
            setContentView(root)

            setVariables(BR.click, this@MainActivity)
            this.vm = viewModel
        }

    }

    override fun onClick(v: View) {
        when(v) {
            binding?.btnWithraw -> {
                viewModel.withDrawAmount()
            }
        }
    }
}