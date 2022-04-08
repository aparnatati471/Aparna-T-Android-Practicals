package android.architecture.bindingandinverseadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityBindingAndReverseBindingAdaptersBinding

class BindingAndReverseBindingAdapters : AppCompatActivity() {

    private lateinit var binding: ActivityBindingAndReverseBindingAdaptersBinding
    private val vm: MyBindingAdapter by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_and_reverse_binding_adapters)
        binding.lifecycleOwner = this
        binding.bindingAdapter = vm
    }

}