package android.architecture.mvvm.view

import android.architecture.mvvm.viewmodel.UserViewModel
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityMvvmLoginBinding


class MvvmLogin : AppCompatActivity() {

    private lateinit var binding: ActivityMvvmLoginBinding

    private val vm:  UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_login)
        binding.viewModel = vm
        binding.lifecycleOwner = this
        binding.btnLogin.setOnClickListener {
            vm.onClick()
        }
        dismissKeyboard()
    }

    private fun dismissKeyboard() {
        binding.baselayout.setOnClickListener {
            if (currentFocus != null) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            }
        }
    }

}
