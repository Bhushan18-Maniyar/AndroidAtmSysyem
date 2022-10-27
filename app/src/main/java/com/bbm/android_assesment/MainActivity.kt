package com.bbm.android_assesment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bbm.android_assesment.databinding.MainActivityBinding
import com.bbm.android_assesment.vm.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
//import com.bbm.android_assesment.BR


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: MainActivityBinding? = null
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(
            layoutInflater
        ).apply {
            lifecycleOwner = this@MainActivity
            setContentView(root)
            click = this@MainActivity
            //setVariable(BR.click, this@MainActivity)
            this.vm = viewModel
        }
    }

    override fun onClick(v: View) {
        when (v) {
            binding?.btnWithdraw -> {
                viewModel.withDrawAmount()
            }
        }
    }
}